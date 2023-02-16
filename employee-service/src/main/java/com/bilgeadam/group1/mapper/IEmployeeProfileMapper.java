package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.request.UpdateTokenRequestDto;
import com.bilgeadam.group1.dto.response.FindAllEmployeeByBriefResponse;
import com.bilgeadam.group1.dto.response.UpdateTokenResponseDto;
import com.bilgeadam.group1.repository.entity.EmployeeProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface IEmployeeProfileMapper {

    IEmployeeProfileMapper INSTANCE = Mappers.getMapper(IEmployeeProfileMapper.class);
    List<FindAllEmployeeByBriefResponse> fromEmployeeListToBriefResponse(final List<EmployeeProfile> employees );
    EmployeeProfile fromCreateRequestToEmployeeProfile(final CreateEmployeeProfileRequest request);
    UpdateTokenResponseDto fromTokenRequestToResponse(final UpdateTokenRequestDto dto);
    EmployeeProfile fromRequestToEmployeeProfile(final CreateEmployeeProfileRequest createEmployeeProfileRequest);
    EmployeeProfile fromProfileUpdateRequestToEmployeeProfile(final ProfileUpdateRequest profileUpdateRequest);
    ProfileUpdateResponse fromEmployeeProfileToProfileUpdateResponse(final EmployeeProfile employeeProfile);
}
