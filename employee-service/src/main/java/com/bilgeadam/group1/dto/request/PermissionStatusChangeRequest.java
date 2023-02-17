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
public class PermissionStatusChangeRequest {

    private Long employeeId;
    private Long permissionId;
    private ConfirmationStatus confirmationType;
    private Long responseDate;
}
