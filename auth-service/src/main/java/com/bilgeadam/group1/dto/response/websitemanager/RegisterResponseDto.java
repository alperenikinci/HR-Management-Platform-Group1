package com.bilgeadam.group1.dto.response.websitemanager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {

    private String email;
    private String password;
    private String activationCode;

}
