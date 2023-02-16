package com.bilgeadam.group1.dto.response;

import com.bilgeadam.group1.repository.enums.ConfirmationType;
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

    private ExpenditureType expenditureType = ExpenditureType.BUSINESS;
    private int price;
    private PriceType priceType = PriceType.TL;
    private String fileUrl;
    private ConfirmationType confirmationType = ConfirmationType.PENDING_APPROVAL;
    @Builder.Default
    private Long createRequestDate = System.currentTimeMillis();
}
