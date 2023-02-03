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
public class UpdateTokenRequestDto {

    @Email(message = "Lutfen e-mail formatinda bir deger giriniz. ")
    @NotBlank(message = "E-mail bilgisi bos gecilemez. Lutfen bir deger giriniz.")
    private String email;

    @NotBlank(message = "Token bilgisi bos gecilemez. Lutfen bir deger giriniz. ")
    private String token;

}
