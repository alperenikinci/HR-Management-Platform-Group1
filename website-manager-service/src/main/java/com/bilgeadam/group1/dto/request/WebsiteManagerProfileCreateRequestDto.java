package com.bilgeadam.group1.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WebsiteManagerProfileCreateRequestDto {

    private Long websiteManagerId;
    private String photoUrl;
    private String name;
    private String middleName;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String token;
}
