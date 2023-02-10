package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ConfirmationType;
import com.bilgeadam.group1.repository.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionRequestDto {

    private Date startedDate;
    private Date finishedDate;
    private String permissionDay;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private PermissionType permissionType = PermissionType.ADMINISTRATIVE;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ConfirmationType permissionConfirmationType = ConfirmationType.PENDING_APPROVAL;
}
