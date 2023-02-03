package com.bilgeadam.group1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProfileUpdateRequest {

    @NotBlank(message = "Token bilgisi bos gecilemez. Lutfen bir deger giriniz. ")
    private String token;
    private String photoUrl;
    private String name;
    private String middleName;
    private String surname;
    private String phone;
    private String address;


}
