package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.AdvanceType;
import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
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


    private Long employeeId;
    @Enumerated(EnumType.STRING)
    private ConfirmationStatus advanceConfirmationType;

    @Enumerated(EnumType.STRING)
    private PriceType priceType;
    private Long salaryCount;
    private String details;

    @Enumerated(EnumType.STRING)
    private AdvanceType advanceType;
}
