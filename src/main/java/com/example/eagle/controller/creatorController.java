package com.example.eagle.controller;

import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.services.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;


@RestController
@RequestMapping("/bookCreator")
public class creatorController {
    @Autowired
    CreatorService creatorService;

    @PostMapping("/signUp")
    public String signUp(CreateAccountRequest createAccountRequest) {
        try {
            creatorService.signUp(createAccountRequest);
            return "account created successfully";

        } catch (NameAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LogInRequest logInRequest){
        try{
            creatorService.login(logInRequest);
            return "login successful";
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
    }

}
