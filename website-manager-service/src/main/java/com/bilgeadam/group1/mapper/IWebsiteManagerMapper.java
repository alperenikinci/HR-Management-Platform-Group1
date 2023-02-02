package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.WebsiteManagerProfileCreateResponseDto;
import com.bilgeadam.group1.repository.entity.WebsiteManagerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IWebsiteManagerMapper {

    IWebsiteManagerMapper INSTANCE = Mappers.getMapper(IWebsiteManagerMapper.class);

    WebsiteManagerProfile fromRequestToWebsiteManagerProfile(final WebsiteManagerProfileCreateRequestDto websiteManagerProfileCreateRequestDto);

    WebsiteManagerProfileCreateResponseDto fromWebsiteManagerProfileToResponse(final WebsiteManagerProfile websiteManagerProfile);

}
