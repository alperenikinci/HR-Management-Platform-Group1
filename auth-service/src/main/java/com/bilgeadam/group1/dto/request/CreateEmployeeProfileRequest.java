package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateEmployeeProfileRequest {

    private Long employeeId;
    private String email;

}
