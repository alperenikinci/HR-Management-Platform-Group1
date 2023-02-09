package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.NewCreateEmployeRequestDto;
import com.bilgeadam.group1.dto.request.RegisterRequestDto;
import com.bilgeadam.group1.dto.response.RegisterResponseDto;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyManagerProfileMapper {

    ICompanyManagerProfileMapper INSTANCE = Mappers.getMapper(ICompanyManagerProfileMapper.class);


    CompanyManagerProfile  toCompanyManager(final RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(final CompanyManagerProfile companyManagerProfile);

    @Mapping(source ="id" ,target ="employeeId")
    NewCreateEmployeRequestDto toNewCreateEmployeeDto(final CompanyManagerProfile companyManagerProfile);

    List<SummarisedFindAllResponse> fromCompanyManagerProfileToResponse(final List<CompanyManagerProfile> companyManagerProfiles);

}
