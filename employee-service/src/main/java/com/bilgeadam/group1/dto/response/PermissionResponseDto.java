package com.bilgeadam.group1.dto.response;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionResponseDto {


    private String permissionType;
    private LocalDate startedDate;
    private LocalDate finishedDate;
    private Long permissionDay;
    private ConfirmationStatus permissionConfirmationType;

    private Long createRequestDate;
}
