package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue
    private Long id;

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
    @Column(unique = true)
    private String email;
    private String address;
    private String phone;
    private String company;




}
