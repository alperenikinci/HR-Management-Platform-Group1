package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.RegisterEmployeeRequestDto;
import com.bilgeadam.group1.dto.request.companydirector.RegisterCompanyDirectorRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.LoginRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.RegisterRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.LoginResponseDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.exception.AuthManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.manager.ICompanyDirectorManager;
import com.bilgeadam.group1.manager.IEmployeeManager;
import com.bilgeadam.group1.manager.IWebsiteManagerManager;
import com.bilgeadam.group1.mapper.IAuthMapper;
import com.bilgeadam.group1.repository.IAuthRepository;
import com.bilgeadam.group1.repository.entity.Auth;
import com.bilgeadam.group1.repository.enums.Roles;
import com.bilgeadam.group1.utility.CodeGenerator;
import com.bilgeadam.group1.utility.JwtTokenManager;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository authRepository;
    private final IWebsiteManagerManager websiteManagerManager;
    private final ICompanyDirectorManager companyDirectorManager;
    private final IEmployeeManager employeeManager;
    private final JwtTokenManager jwtTokenManager;
    public AuthService(JpaRepository<Auth, Long> repository, IAuthRepository authRepository, IWebsiteManagerManager websiteManagerManager, ICompanyDirectorManager companyDirectorManager, IEmployeeManager employeeManager, JwtTokenManager jwtTokenManager) {
        super(repository);
        this.authRepository = authRepository;
        this.websiteManagerManager = websiteManagerManager;
        this.companyDirectorManager = companyDirectorManager;
        this.employeeManager = employeeManager;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Transactional
    public RegisterResponseDto registerWebsiteManager(RegisterRequestDto dto){
        if(authRepository.findOptionalByEmail(dto.getEmail()).isPresent()){
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
        if(!dto.getPassword().equals(dto.getRePassword())){
            throw new AuthManagerException(ErrorType.REGISTER_REPASSWORD_ERROR);
        }
        try {
            Auth auth = IAuthMapper.INSTANCE.fromRequestToWebsiteManager(dto);
            save(auth);
            websiteManagerManager.createWebsiteManagerProfile(IAuthMapper.INSTANCE.fromWebsiteManagerToWebsiteManagerProfileCreateRequestDto(auth));
            return IAuthMapper.INSTANCE.fromAuthToResponse(auth);
        } catch (Exception e){
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
    }

    @Transactional
    public RegisterResponseDto registerCompanyDirector(RegisterCompanyDirectorRequestDto dto) {
        if (authRepository.findOptionalByEmail(dto.getEmail()).isPresent()) {
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
        try {
            Auth auth = new Auth();
            auth.setEmail(dto.getEmail());
            auth.setPassword(CodeGenerator.generateCode());
            auth.setRole(Roles.COMPANY_DIRECTOR);
            save(auth);
            companyDirectorManager.createCompanyManagerProfile(IAuthMapper.INSTANCE.fromAuthToCompanyDirectorProfileCreateRequestDto(auth));
            return IAuthMapper.INSTANCE.fromAuthToResponse(auth);
        } catch (Exception e) {
            throw new AuthManagerException(ErrorType.INTERNAL_ERROR);
        }
    }

    @Transactional
    public RegisterResponseDto registerEmployee(RegisterEmployeeRequestDto dto){
        if (authRepository.findOptionalByEmail(dto.getEmail()).isPresent()) {
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }

        if(!authRepository.findOptionalByToken(dto.getToken()).isPresent() && !authRepository.findOptionalByToken(dto.getToken()).get().getRole().equals(Roles.COMPANY_DIRECTOR)){
            throw new AuthManagerException(ErrorType.UNAUTHORISED_REGISTER_ATTEMPT);
        }
        try{
                Auth auth = IAuthMapper.INSTANCE.fromRequestToEmployee(dto);
                auth.setEmail(dto.getEmail());
                auth.setPassword(CodeGenerator.generateCode());
                auth.setRole(Roles.EMPLOYEE);
                auth.setToken("");
                save(auth);
                employeeManager.createEmployeeProfile(IAuthMapper.INSTANCE.fromAuthToEmployeeCreateRequest(auth));
                return IAuthMapper.INSTANCE.fromAuthToResponse(auth);
        }
        catch (Exception e){
            throw new AuthManagerException(ErrorType.INTERNAL_ERROR);
        }
    }
    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<Auth> auth = authRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
        }
        LoginResponseDto loginResponseDto = IAuthMapper.INSTANCE.fromAuthToLoginResponseDto(auth.get());
        String token = jwtTokenManager.createToken(auth.get().getId());
        if(auth.get().getRole().equals(Roles.WEBSITE_MANAGER) || auth.get().getRole().equals(Roles.ADMIN)){
            loginResponseDto.setToken(token);
            UpdateTokenRequestDto updateTokenRequestDto = UpdateTokenRequestDto.builder()
                    .token(token)
                    .email(loginResponseDto.getEmail())
                    .build();
            websiteManagerManager.updateTokenByEmail(updateTokenRequestDto);
            auth.get().setToken(token);
            authRepository.save(auth.get());

        }
        if(auth.get().getRole().equals(Roles.COMPANY_DIRECTOR)){
            loginResponseDto.setToken(token);
            UpdateTokenRequestDto updateTokenRequestDto = UpdateTokenRequestDto.builder()
                    .token(token)
                    .email(loginResponseDto.getEmail())
                    .build();
            companyDirectorManager.updateTokenByEmail(updateTokenRequestDto);
            auth.get().setToken(token);
            authRepository.save(auth.get());
        }
        if(auth.get().getRole().equals(Roles.EMPLOYEE)){
            loginResponseDto.setToken(token);
            UpdateTokenRequestDto updateTokenRequestDto = UpdateTokenRequestDto.builder()
                    .token(token)
                    .email(loginResponseDto.getEmail())
                    .build();
            employeeManager.updateTokenByEmail(updateTokenRequestDto);
            auth.get().setToken(token);
            authRepository.save(auth.get());
        }
        return loginResponseDto;
    }

    public List<Auth> findAllByRole(Roles role){
        return authRepository.findAllByRole(role);
    }


    public String forgotPassword(String email) {
       Optional<Auth> auth = authRepository.findOptionalByEmail(email);
        String password = CodeGenerator.generateCode();
       if(!auth.isPresent()){
           throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
       }
       try {
            auth.get().setPassword(password);
            authRepository.save(auth.get());
       }catch (Exception e){
           throw new AuthManagerException(ErrorType.INTERNAL_ERROR);
       }
       return "Sifreniz basariyla sifirlanmistir. Yeni sifreniz ile giris yapabilirsiniz : " + password;
    }
}
