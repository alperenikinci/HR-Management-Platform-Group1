package com.bilgeadam.group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WebsiteManagerProfileCreateResponseDto {

    private Long websiteManagerId;
    private String photoUrl;
    private String name;
    private String middleName;
    private String surname;
}
