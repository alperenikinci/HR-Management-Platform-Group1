package com.bilgeadam.group1.dto.response;

import com.bilgeadam.group1.repository.enums.AdvanceType;
import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import com.bilgeadam.group1.repository.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvanceResponseDto {

    private ConfirmationStatus confirmationType;
    private PriceType priceType;
    private int price;
    private String details;
    private AdvanceType advanceType;

    @Builder.Default
    private Long createRequestDate = System.currentTimeMillis();
}
