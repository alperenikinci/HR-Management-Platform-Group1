package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.ConfirmationType;
import com.bilgeadam.group1.repository.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Date startedDate;
    private Date finishedDate;
    private String permissionDay;
    private PermissionType permissionType;
    private ConfirmationType permissionConfirmationType;

}
