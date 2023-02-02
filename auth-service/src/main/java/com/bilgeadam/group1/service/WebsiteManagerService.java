package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.LoginRequestDto;
import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.LoginResponseDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.exception.AuthManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.manager.IWebsiteManagerManager;
import com.bilgeadam.group1.mapper.IWebsiteManagerMapper;
import com.bilgeadam.group1.repository.IWebsiteManagerRepository;
import com.bilgeadam.group1.repository.entity.WebsiteManager;
import com.bilgeadam.group1.utility.CodeGenerator;
import com.bilgeadam.group1.utility.JwtTokenManager;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WebsiteManagerService extends ServiceManager<WebsiteManager,Long > {

    private final IWebsiteManagerRepository websiteManagerRepository;
    private final IWebsiteManagerManager websiteManagerManager;
    private final JwtTokenManager jwtTokenManager;


    public WebsiteManagerService(IWebsiteManagerRepository websiteManagerRepository, IWebsiteManagerManager websiteManagerManager, JwtTokenManager jwtTokenManager) {
        super(websiteManagerRepository);
        this.websiteManagerRepository=websiteManagerRepository;
        this.websiteManagerManager = websiteManagerManager;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Transactional
    public RegisterResponseDto registerWebsiteManager(RegisterRequestDto dto){
        if(websiteManagerRepository.findOptionalByEmail(dto.getEmail()).isPresent()){
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
        if(!dto.getPassword().equals(dto.getRePassword())){
            throw new AuthManagerException(ErrorType.REGISTER_REPASSWORD_ERROR);
        }
        try {
            WebsiteManager websiteManager = IWebsiteManagerMapper.INSTANCE.fromRequestToWebsiteManager(dto);
            websiteManager.setActivationCode(CodeGenerator.generateCode());
            save(websiteManager);
            websiteManagerManager.createWebsiteManagerProfile(IWebsiteManagerMapper.INSTANCE.fromWebsiteManagerToWebsiteManagerProfileCreateRequestDto(websiteManager));
            return IWebsiteManagerMapper.INSTANCE.fromWebsiteManagerToResponse(websiteManager);
        } catch (Exception e){
            System.out.println(e.toString());
            throw new AuthManagerException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }


    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<WebsiteManager> websiteManager = websiteManagerRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (websiteManager.isEmpty()) {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
        }
        LoginResponseDto loginResponseDto = IWebsiteManagerMapper.INSTANCE.fromWebsiteManagerToLoginResponseDto(websiteManager.get());
        String token = jwtTokenManager.createToken(websiteManager.get().getId());
        loginResponseDto.setToken(token);
        UpdateTokenRequestDto updateTokenRequestDto = UpdateTokenRequestDto.builder()
                .token(token)
                .email(loginResponseDto.getEmail())
                .build();
        websiteManagerManager.updateTokenByEmail(updateTokenRequestDto);

        return loginResponseDto;
    }

    public List<WebsiteManager> findAll(){
        return websiteManagerRepository.findAll();
    }



}
