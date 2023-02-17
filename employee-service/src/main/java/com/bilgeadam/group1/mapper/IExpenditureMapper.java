package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.response.ExpenditureResponseDto;
import com.bilgeadam.group1.repository.entity.Expenditure;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IExpenditureMapper {

    IExpenditureMapper INSTANCE = Mappers.getMapper(IExpenditureMapper.class);

    ExpenditureResponseDto fromExpenditureToExpenditureResponse(final Expenditure expenditure);
}
