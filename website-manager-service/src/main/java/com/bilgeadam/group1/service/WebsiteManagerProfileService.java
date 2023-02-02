package com.bilgeadam.group1.service;


import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.WebsiteManagerProfileCreateResponseDto;
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


    public WebsiteManagerProfileCreateResponseDto createWebsiteManagerProfile (WebsiteManagerProfileCreateRequestDto dto){
        WebsiteManagerProfile profile = IWebsiteManagerMapper.INSTANCE.fromRequestToWebsiteManagerProfile(dto);
        websiteManagerProfileRepository.save(profile);
        return IWebsiteManagerMapper.INSTANCE.fromWebsiteManagerProfileToResponse(profile);
    }
}
