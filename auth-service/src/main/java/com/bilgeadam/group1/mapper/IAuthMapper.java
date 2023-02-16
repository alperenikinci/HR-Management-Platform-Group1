package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.request.RegisterEmployeeRequestDto;
import com.bilgeadam.group1.dto.request.companydirector.CompanyManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.RegisterRequestDto;
import com.bilgeadam.group1.dto.request.websitemanager.WebsiteManagerProfileCreateRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.LoginResponseDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);
    Auth fromRequestToWebsiteManager(final RegisterRequestDto dto);
    RegisterResponseDto fromAuthToResponse(final Auth auth);

    LoginResponseDto fromAuthToLoginResponseDto(final  Auth auth);
    Auth fromRequestToEmployee(final RegisterEmployeeRequestDto dto);
    @Mapping(source ="id" ,target ="companyManagerId")
    CompanyManagerProfileCreateRequestDto fromAuthToCompanyDirectorProfileCreateRequestDto(final Auth auth);
    @Mapping(source ="id" ,target ="employeeId")
    CreateEmployeeProfileRequest fromAuthToEmployeeCreateRequest(final Auth auth);
    @Mapping(source ="id" ,target ="websiteManagerId")
    WebsiteManagerProfileCreateRequestDto fromWebsiteManagerToWebsiteManagerProfileCreateRequestDto(final Auth auth);
}
