package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import com.bilgeadam.group1.repository.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionRequestDto {

    private Long employeeId;
    private LocalDate permissionRequestDate;
    private LocalDate startedDate;
    private LocalDate finishedDate;

    @Enumerated(EnumType.STRING)
    private PermissionType permissionType;

    @Enumerated(EnumType.STRING)
    private ConfirmationStatus permissionConfirmationType;
}
