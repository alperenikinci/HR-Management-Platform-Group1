package com.bilgeadam.group1.dto.request;

import com.bilgeadam.group1.repository.enums.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateEmployeeProfileRequest {
    private String photoUrl;
    private String name;
    private String middleName;
    private String surname;
    private Long dateOfBirth;
    private String birthplace;
    private Long identityNumber;
    private Long dateOfRecruitment;
    private Long terminationDate;
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;
    private String profession;
    private String department;
    @Email
    private String email;
    private String address;
    private String phone;
    private String company;
}
