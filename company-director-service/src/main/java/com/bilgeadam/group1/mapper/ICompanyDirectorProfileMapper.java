package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.*;
import com.bilgeadam.group1.dto.response.ProfileUpdateResponse;
import com.bilgeadam.group1.dto.response.SummarisedFindAllResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.CompanyManagerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyDirectorProfileMapper {

    ICompanyDirectorProfileMapper INSTANCE = Mappers.getMapper(ICompanyDirectorProfileMapper.class);


    CompanyManagerProfile fromRequestToCompanyManagerProfile(final CompanyManagerProfileCreateRequestDto companyManagerProfileCreateRequestDto);

    UpdateTokenResponseDto fromTokenRequestToResponse(final UpdateTokenRequestDto dto);

    CompanyManagerProfile fromProfileUpdateRequestToCompanyManagerProfile(final ProfileUpdateRequest profileUpdateRequest);

    ProfileUpdateResponse fromCompanyManagerProfileToProfileUpdateResponse(final CompanyManagerProfile companyManagerProfile);

    List<SummarisedFindAllResponse> fromCompanyManagerProfileToResponse(final List<CompanyManagerProfile> companyManagerProfiles);




}
