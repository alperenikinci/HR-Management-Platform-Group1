package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ConfirmationType;
import com.bilgeadam.group1.repository.enums.ExpenditureType;
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
public class ExpenditureRequestDto {

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ExpenditureType expenditureType = ExpenditureType.BUSINESS;
    private int price;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private PriceType priceType = PriceType.TL;
    private String fileUrl;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ConfirmationType expenditureConfirmationType = ConfirmationType.PENDING_APPROVAL;

}
