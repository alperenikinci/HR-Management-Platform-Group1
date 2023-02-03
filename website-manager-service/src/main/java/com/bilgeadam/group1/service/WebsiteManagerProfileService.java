package com.bilgeadam.group1.service;


import com.bilgeadam.group1.dto.request.ProfileUpdateRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.exception.ErrorType;
import com.bilgeadam.group1.exception.WebsiteManagerException;
import com.bilgeadam.group1.mapper.IWebsiteManagerProfileMapper;
import com.bilgeadam.group1.repository.IWebsiteManagerProfileRepository;
import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import com.bilgeadam.group1.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WebsiteManagerProfileService extends ServiceManager<WebsiteManagerProfile,Long > {

    private final IWebsiteManagerProfileRepository websiteManagerProfileRepository;
    private final  IWebsiteManagerProfileMapper websiteManagerProfileMapper;

    public WebsiteManagerProfileService(IWebsiteManagerProfileRepository websiteManagerProfileRepository, IWebsiteManagerProfileMapper websiteManagerProfileMapper) {
        super(websiteManagerProfileRepository);
        this.websiteManagerProfileRepository = websiteManagerProfileRepository;
        this.websiteManagerProfileMapper = websiteManagerProfileMapper;
    }


    public boolean createWebsiteManagerProfile (WebsiteManagerProfileCreateRequestDto dto){
        try {
            WebsiteManagerProfile profile = IWebsiteManagerProfileMapper.INSTANCE.fromRequestToWebsiteManagerProfile(dto);
            websiteManagerProfileRepository.save(profile);
            return true;
        }catch (Exception e){
            throw new WebsiteManagerException(ErrorType.WEBSITE_MANAGER_NOT_CREATED);
        }
    }

//    public UpdateTokenResponseDto updateToken(UpdateTokenRequestDto dto){
//
//        if(websiteManagerProfileRepository.findByEmail(dto.getEmail()).equals(true)){
//            WebsiteManagerProfile profile = websiteManagerProfileRepository.findByEmail(dto.getEmail());
//            profile.setToken(dto.getToken());
//            websiteManagerProfileRepository.save(profile);
//            return IWebsiteManagerMapper.INSTANCE.fromWebsiteManagerToUpdateTokenResponseDto(profile);
//        }
//        else
//            throw new RuntimeException();
//    }

    public Optional<WebsiteManagerProfile> findByEmail(String email){
        return websiteManagerProfileRepository.findOptionalByEmail(email);
    }

    public Optional<UpdateTokenResponseDto> updateTokenByEmail(UpdateTokenRequestDto dto){
        Optional<WebsiteManagerProfile> profile = websiteManagerProfileRepository.findOptionalByEmail(dto.getEmail());
        if(!profile.isPresent()){
            throw new WebsiteManagerException(ErrorType.USER_NOT_FOUND);
        }
        profile.get().setToken(dto.getToken());
        websiteManagerProfileRepository.save(profile.get());
        return Optional.ofNullable(websiteManagerProfileMapper.INSTANCE.fromTokenRequestToResponse(dto));
    }

    public Optional<WebsiteManagerProfile> findOptionalByToken(String token){
        return websiteManagerProfileRepository.findOptionalByToken(token);
    }

    public Optional<ProfileUpdateResponse> updateProfileByToken(ProfileUpdateRequest request){
        Optional<WebsiteManagerProfile> profile = websiteManagerProfileRepository.findOptionalByToken(request.getToken());
        if(!profile.isPresent()){
            throw new WebsiteManagerException(ErrorType.USER_NOT_FOUND);
        }
        profile.get().setName(request.getName());
        profile.get().setPhotoUrl(request.getPhotoUrl());
        profile.get().setMiddleName(request.getMiddleName());
        profile.get().setSurname(request.getSurname());
        profile.get().setPhone(request.getPhone());
        profile.get().setAddress(request.getAddress());
        profile.get().setUpdateDate(System.currentTimeMillis());
        save(profile.get());
        return Optional.ofNullable(websiteManagerProfileMapper.INSTANCE.fromWebsiteManagerProfileToProfileUpdateResponse(profile.get()));
    }
    public List<WebsiteManagerProfile> findAll(){
        return websiteManagerProfileRepository.findAll();
    }

    public List<SummarisedFindAllResponse> findAllBySummarisedInformation(){
        List<WebsiteManagerProfile> responseList = websiteManagerProfileRepository.findAll();
       return IWebsiteManagerProfileMapper.INSTANCE.fromWebsiteManagerProfileToResponse(responseList);
    }
}
