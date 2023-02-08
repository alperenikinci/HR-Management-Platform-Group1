package com.bilgeadam.group1.dto.request.websitemanager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateTokenRequestDto {
    private String email;
    private String token;

}
