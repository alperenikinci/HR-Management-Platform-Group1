package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.PermissionRequestDto;
import com.bilgeadam.group1.dto.response.PermissionResponseDto;
import com.bilgeadam.group1.repository.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPermissionMapper {

    IPermissionMapper INSTANCE = Mappers.getMapper(IPermissionMapper.class);
    Permission fromPermRequestToPermission(final PermissionRequestDto dto);
    PermissionResponseDto fromPermissionToPermResponse(final Permission permission);

}
