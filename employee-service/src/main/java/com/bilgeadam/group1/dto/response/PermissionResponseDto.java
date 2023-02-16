package com.bilgeadam.group1.dto.response;

import com.bilgeadam.group1.repository.enums.ConfirmationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionResponseDto {

    private String permissionType;
    private Date startedDate;
    private Date finishedDate;
    private String permissionDay;
    private ConfirmationType permissionConfirmationType;
    @Builder.Default
    private Long createRequestDate = System.currentTimeMillis();
}
