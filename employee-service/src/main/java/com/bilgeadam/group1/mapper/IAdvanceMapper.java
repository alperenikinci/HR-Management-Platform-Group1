package com.bilgeadam.group1.mapper;

import com.bilgeadam.group1.dto.response.AdvanceResponseDto;
import com.bilgeadam.group1.repository.entity.Advance;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAdvanceMapper {
    IAdvanceMapper INSTANCE = Mappers.getMapper(IAdvanceMapper.class);

    AdvanceResponseDto fromAdvanceToResponse(final Advance advance);
}
