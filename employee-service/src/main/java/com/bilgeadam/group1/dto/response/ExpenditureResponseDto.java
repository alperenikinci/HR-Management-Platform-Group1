package com.bilgeadam.group1.dto.response;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import com.bilgeadam.group1.repository.enums.ExpenditureType;
import com.bilgeadam.group1.repository.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenditureResponseDto {

    private ExpenditureType expenditureType;
    private int price;
    private PriceType priceType;
    private String fileUrl;
    private ConfirmationStatus confirmationType;

    @Builder.Default
    private Long createRequestDate = System.currentTimeMillis();
}
