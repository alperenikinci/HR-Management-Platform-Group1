package com.bilgeadam.group1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {


    INTERNAL_ERROR(5100,"Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(1100,"Parametre Hatası",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1111,"Boyle Bir kullanıcı bulunamadı",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(1112,"Kullanıcı adı veya şifre Hatalı",HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(1113,"Kullan?c? Olusturlamad?",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1114,"Gecersiz Token?",HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
