package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.AdvanceType;
import com.bilgeadam.group1.repository.enums.ConfirmationType;
import com.bilgeadam.group1.repository.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvanceRequestDto {


    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ConfirmationType advanceConfirmationType = ConfirmationType.PENDING_APPROVAL;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private PriceType priceType = PriceType.TL;

    @Size(max = 3)
    private int price;
    private String details;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private AdvanceType advanceType = AdvanceType.PERSONAL;
}
