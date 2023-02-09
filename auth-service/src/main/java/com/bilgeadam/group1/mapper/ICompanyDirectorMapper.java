package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.companydirector.CompanyManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.LoginResponseDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.CompanyDirector;
import com.bilgeadam.group1.repository.entity.WebsiteManager;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyDirectorMapper {
    ICompanyDirectorMapper INSTANCE = Mappers.getMapper(ICompanyDirectorMapper.class);

    RegisterResponseDto fromCompanyDirectorToResponse(final CompanyDirector companyDirector);

    CompanyManagerProfileCreateRequestDto fromCompanyDirectorToCompanyDirectorProfileCreateRequestDto(final CompanyDirector companyDirector);

    LoginResponseDto fromCompanyDirectorToLoginResponseDto(final CompanyDirector companyDirector);
}
