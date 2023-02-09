package com.bilgeadam.group1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCreateEmployeRequestDto {

    private Long employeeId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String company;
}
