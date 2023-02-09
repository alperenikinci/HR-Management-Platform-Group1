package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.ProfileUpdateRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IWebsiteManagerProfileMapper {

    IWebsiteManagerProfileMapper INSTANCE = Mappers.getMapper(IWebsiteManagerProfileMapper.class);


    WebsiteManagerProfile fromRequestToWebsiteManagerProfile(final WebsiteManagerProfileCreateRequestDto websiteManagerProfileCreateRequestDto);

    UpdateTokenResponseDto fromTokenRequestToResponse(final UpdateTokenRequestDto dto);

    WebsiteManagerProfile fromProfileUpdateRequestToWebsiteManagerProfile(final ProfileUpdateRequest profileUpdateRequest);

    ProfileUpdateResponse fromWebsiteManagerProfileToProfileUpdateResponse(final WebsiteManagerProfile websiteManagerProfile);

    List<SummarisedFindAllResponse> fromWebsiteManagerProfileToResponse(final List<WebsiteManagerProfile> websiteManagerProfiles);

}
