package com.bilgeadam.group1.dto.request.companydirector;

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
public class RegisterCompanyDirectorRequestDto {
    @Email(message = "Lutfen gecerli bir e-mail adresi giriniz.")
    @NotBlank(message = "Kullanici e-maili bos gecilemez.")
    private String email;
}
