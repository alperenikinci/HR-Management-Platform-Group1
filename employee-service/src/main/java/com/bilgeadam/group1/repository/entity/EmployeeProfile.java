package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.ActiveStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
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
    private String token;

    @JsonIgnore
    @Builder.Default
    @OneToMany
    List<Advance> advanceList = new ArrayList<>();
    @JsonIgnore
    @Builder.Default
    @OneToMany
    List<Expenditure> expenditureList = new ArrayList<>();
    @JsonIgnore
    @Builder.Default
    @OneToMany
    List<Permission> permissionList = new ArrayList<>();




}
