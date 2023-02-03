package com.bilgeadam.group1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {


    INTERNAL_ERROR(5100,"Sunucu Hatasi", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(2100,"Parametre Hatasi",HttpStatus.BAD_REQUEST),
    EMAIL_NOT_FOUND(2117,"Bu email'e ait bir kullanici bulunamadi.",HttpStatus.BAD_REQUEST),
    WEBSITE_MANAGER_NOT_CREATED(2118,"WebsiteManager Olusturulamadi",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(2114,"Gecersiz Token?",HttpStatus.BAD_REQUEST);
    //TODO hata açıklamasına bak.
    private int code;
    private String message;
    HttpStatus httpStatus;
}
