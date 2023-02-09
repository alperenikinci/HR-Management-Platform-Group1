package com.bilgeadam.group1.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CompanyManagerProfile {


    /**
     * Fotoğraf, Adı, İkinci Adı, Soyadı,
     * İkinci Soyadı, Doğum tarihi, Doğum Yeri ,
     * TC, İşe Giriş T,Meslek, Departman, Email (ad.soyad@bilgeadamboost.com),
     * Adres, Telefon,Şirket seç özellikleri var.
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long websiteManagerId;
    private String photoUrl;
    private String name;
    private String middleName;
    private String surname;
    private String birthOfCity;
    private Long birthDate;
    private Long citizenId;
    private Long startDateOfWork;
    private String job;
    private String department;
    private String company;

    @Email
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String token;
    private String activationCode;
    @Builder.Default
    private Long createDate = System.currentTimeMillis();
    @Builder.Default
    private Long updateDate = System.currentTimeMillis();
}
