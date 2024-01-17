package com.example.eagle.exceptions;

public class NameAlreadyExistException extends Exception {
    public NameAlreadyExistException(String userNameAlreadyExist) {
        super(userNameAlreadyExist);
    }
}
