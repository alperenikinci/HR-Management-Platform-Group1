package com.bilgeadam.group1.service;

import com.bilgeadam.group1.dto.request.LoginRequestDto;
import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.LoginResponseDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.exception.AuthManagerException;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.mapper.IWebsiteManagerMapper;
import com.bilgeadam.group1.repository.IWebsiteManagerRepository;
import com.bilgeadam.group1.repository.entity.WebsiteManager;
import com.bilgeadam.group1.utility.CodeGenerator;
import com.bilgeadam.group1.utility.JwtTokenManager;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.group1.constants.RestApi.FINDALL;

@Service
public class WebsiteManagerService extends ServiceManager<WebsiteManager,Long > {

    private final IWebsiteManagerRepository websiteManagerRepository;
    private final JwtTokenManager jwtTokenManager;


    public WebsiteManagerService(IWebsiteManagerRepository websiteManagerRepository, JwtTokenManager jwtTokenManager) {
        super(websiteManagerRepository);
        this.websiteManagerRepository=websiteManagerRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Transactional
    public RegisterResponseDto registerWebsiteManager(RegisterRequestDto dto){

        WebsiteManager websiteManager = IWebsiteManagerMapper.INSTANCE.fromRequestToWebsiteManager(dto);
        if(!dto.getPassword().equals(dto.getRePassword())){
            throw new AuthManagerException(ErrorType.REGISTER_REPASSWORD_ERROR);
        }
        try {
            websiteManager.setActivationCode(CodeGenerator.generateCode());
            save(websiteManager);
            //TODO website manager service yapıldığı zaman buradan bir websitemanager profili oluşturulacak.
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
        LoginResponseDto loginResponseDto = IWebsiteManagerMapper.INSTANCE.toLoginResponseDto(websiteManager.get());
        loginResponseDto.setToken(jwtTokenManager.createToken(websiteManager.get().getId()));

        return loginResponseDto;
    }

    public List<WebsiteManager> findAll(){
        return websiteManagerRepository.findAll();
    }



}
