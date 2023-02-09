package com.bilgeadam.group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindAllEmployeeByBriefResponse {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String company;
}
