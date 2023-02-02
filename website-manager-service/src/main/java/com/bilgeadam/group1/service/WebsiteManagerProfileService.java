package com.bilgeadam.group1.service;


import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.exception.WebsiteManagerException;
import com.bilgeadam.group1.mapper.IWebsiteManagerMapper;
import com.bilgeadam.group1.repository.IWebsiteManagerProfileRepository;
import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import org.springframework.stereotype.Service;

@Service
public class WebsiteManagerProfileService {

    private final IWebsiteManagerProfileRepository websiteManagerProfileRepository;

    public WebsiteManagerProfileService(IWebsiteManagerProfileRepository websiteManagerProfileRepository) {
        this.websiteManagerProfileRepository = websiteManagerProfileRepository;
    }


    public boolean createWebsiteManagerProfile (WebsiteManagerProfileCreateRequestDto dto){
        try {
            WebsiteManagerProfile profile = IWebsiteManagerMapper.INSTANCE.fromRequestToWebsiteManagerProfile(dto);
            websiteManagerProfileRepository.save(profile);
            return true;
        }catch (Exception e){
            throw new WebsiteManagerException(ErrorType.WEBSITE_MANAGER_NOT_CREATED);
        }
    }

    public Boolean updateToken(UpdateTokenRequestDto dto){
        WebsiteManagerProfile profile = IWebsiteManagerMapper.INSTANCE.fromTokenUpdateRequestToWebsiteManagerProfile(dto);
        websiteManagerProfileRepository.save(profile);
        return true;
    }
}
