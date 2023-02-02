package com.bilgeadam.group1.exception;

import lombok.Getter;

@Getter
public class WebsiteManagerException extends  RuntimeException {

    private final ErrorType errorType;


    public WebsiteManagerException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public WebsiteManagerException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
