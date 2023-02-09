package com.bilgeadam.group1.dto.response.company;

import com.bilgeadam.group1.repository.enums.CompanyTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindAllCompaniesByBriefResponse {

    private String name;
    private CompanyTypes companyType;
    private String phone;
    private String address;

}
