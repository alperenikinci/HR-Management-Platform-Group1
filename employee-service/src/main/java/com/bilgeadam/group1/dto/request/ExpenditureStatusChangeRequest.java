package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExpenditureStatusChangeRequest {

    private Long employeeId;
    private Long expenditureId;
    private ConfirmationStatus confirmationType;
    private Long responseDate;
}
