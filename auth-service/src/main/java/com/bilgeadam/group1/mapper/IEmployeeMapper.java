package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.CreateEmployeeProfileRequest;
import com.bilgeadam.group1.dto.request.RegisterEmployeeRequestDto;
import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee fromRequestToEmployee(final RegisterEmployeeRequestDto dto);

    RegisterResponseDto fromEmployeeToResponse(final Employee employee);
    @Mapping(source ="id" ,target ="employeeId")
    CreateEmployeeProfileRequest fromEmployeeToEmployeeCreateRequest(final Employee employee);

}
