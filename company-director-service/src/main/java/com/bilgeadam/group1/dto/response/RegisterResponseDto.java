package com.bilgeadam.group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String activationCode;
}
