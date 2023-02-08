package com.bilgeadam.group1.dto.request.company;

import com.bilgeadam.group1.repository.enums.CompanyActiveStatus;
import com.bilgeadam.group1.repository.enums.CompanyTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateCompanyRequestDto {

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
    private String dateOfEstablishmentAsString;
    private String effectiveDateAsLocalDateAsString;
    private String contactTerminationDateAsLocalDateAsString;
    @Enumerated(EnumType.STRING)
    private CompanyActiveStatus activeStatus;
}
