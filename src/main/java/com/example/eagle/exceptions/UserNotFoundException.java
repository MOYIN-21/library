package com.example.eagle.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
