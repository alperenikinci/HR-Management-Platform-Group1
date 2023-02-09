package com.bilgeadam.group1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyManagerProfileCreateRequestDto {

    private Long companyManagerId;
    private String email;
    private String token;
}
