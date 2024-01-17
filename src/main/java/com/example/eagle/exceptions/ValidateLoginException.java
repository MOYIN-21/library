package com.example.eagle.exceptions;

public class ValidateLoginException extends Exception {
    public ValidateLoginException(String userNameDoesNotExist) {
        super(userNameDoesNotExist);
    }
}
