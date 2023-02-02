package com.bilgeadam.group1.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class WebsiteManagerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long websiteManagerId;
    private String photoUrl;
    private String name;
    private String middleName;
    private String surname;

    @Email
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String token;
    @Builder.Default
    private Long createDate = System.currentTimeMillis();
    @Builder.Default
    private Long updateDate = System.currentTimeMillis();


}
