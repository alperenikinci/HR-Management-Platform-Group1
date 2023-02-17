package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
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

    private Long employeeId;
    @Enumerated(EnumType.STRING)
    private ExpenditureType expenditureType;

    private int price;

    @Enumerated(EnumType.STRING)
    private PriceType priceType;
    private String fileUrl;
    private ConfirmationStatus expenditureConfirmationType;

}
