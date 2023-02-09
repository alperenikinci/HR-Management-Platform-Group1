package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.response.websitemanager.RegisterResponseDto;
import com.bilgeadam.group1.repository.entity.CompanyDirector;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyDirectorMapper {
    ICompanyDirectorMapper INSTANCE = Mappers.getMapper(ICompanyDirectorMapper.class);

    RegisterResponseDto fromCompanyDirectorToResponse(final CompanyDirector companyDirector);
}
