package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.WebsiteManager;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IWebsiteManagerMapper {

    IWebsiteManagerMapper INSTANCE = Mappers.getMapper(IWebsiteManagerMapper.class);

    WebsiteManager fromRequestToWebsiteManager(final RegisterRequestDto dto);

    RegisterResponseDto fromWebsiteManagerToResponse(final WebsiteManager websiteManager);


}
