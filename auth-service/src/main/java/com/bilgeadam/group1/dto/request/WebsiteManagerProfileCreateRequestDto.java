package com.bilgeadam.group1.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WebsiteManagerProfileCreateRequestDto {

    private Long websiteManagerId;

    @Email(message = "Lufen e-mail formatinda bir deger giriniz.")
    @NotBlank(message = "E-mail bos gecilemez. ")
    private String email;

    @NotBlank(message = "Token bilgisi bos gecilemez. Lutfen token bilgisi giriniz.")
    private String token;
}
