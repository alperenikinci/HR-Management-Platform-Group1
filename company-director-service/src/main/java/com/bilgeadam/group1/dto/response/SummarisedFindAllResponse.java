package com.bilgeadam.group1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummarisedFindAllResponse {
    /**
     * ad,soyad,tel,email,şirket*/

    private String name;
    private String middleName;
    private String surname;
    private String phone;
    private String email;
    private String company;
}
