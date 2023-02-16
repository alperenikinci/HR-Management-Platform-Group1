package com.bilgeadam.group1.exception;

import lombok.Getter;

@Getter
public class EmployeeException extends  RuntimeException {

    private final ErrorType errorType;


    public EmployeeException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public EmployeeException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
