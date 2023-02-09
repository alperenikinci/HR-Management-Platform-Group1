package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.request.company.CreateCompanyRequestDto;
import com.bilgeadam.group1.dto.response.company.FindAllCompaniesByBriefResponse;
import com.bilgeadam.group1.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ICompanyMapper {

    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company fromRequestToCompany(final CreateCompanyRequestDto dto);

    List<FindAllCompaniesByBriefResponse> fromCompanyListToBriefResponse(final List<Company> companies);
}
