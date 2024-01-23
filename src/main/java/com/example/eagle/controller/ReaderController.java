package com.example.eagle.controller;

import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;
@RestController
@RequestMapping("/libraryUser")
public class ReaderController {
    @Autowired
    ReaderService readerService;


    @PostMapping("/userSignUp")
    public String SignUp(@RequestBody CreateAccountRequest createAccountRequest) {
        try {
            readerService.register(createAccountRequest);
            return "User account created successfully";

        } catch (NameAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestBody LogInRequest logInRequest) throws LoginException {
        try {
            readerService.login(logInRequest);
            return "successful";
        } catch (LoginException e) {
            throw new LoginException();
        }
    }
}
