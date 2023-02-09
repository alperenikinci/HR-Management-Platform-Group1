package com.bilgeadam.group1.repository.entity;

import com.bilgeadam.group1.repository.enums.CompanyActiveStatus;
import com.bilgeadam.group1.repository.enums.CompanyTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CompanyTypes companyType;
    private String centralRegistrationSystemNumber;
    private Long taxRegisterNumber;
    private String taxDepartment;
    private String logoUrl;
    private String phone;
    private String address;
    private String email;
    private Long numberOfEmployees;
    private Long dateOfEstablishment;
    private Long effectiveDate;
    private Long contactTerminationDate;
    @Enumerated(EnumType.STRING)
    private CompanyActiveStatus activeStatus;

}
