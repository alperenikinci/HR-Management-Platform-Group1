package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.ConfirmationStatus;
import com.bilgeadam.group1.repository.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startedDate;
    private LocalDate finishedDate;
    private Long permissionDay;
    private Long createRequestDate;
    private Long responseDate;
    private PermissionType permissionType;
    private ConfirmationStatus permissionConfirmationType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeProfile employeeProfile;

}
