package com.example.eagle.controller;

import com.example.eagle.dtos.BookDto;
import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import com.example.eagle.services.BookService;
import com.example.eagle.services.CreatorService;
import com.example.eagle.services.LibraryService;
import com.example.eagle.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @Autowired
    CreatorService creatorService;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @PostMapping("/createAccount")
    public String openAccount(CreateAccountRequest createAccountRequest){
        try{
            creatorService.register(createAccountRequest);
            return "account created successfully";

        } catch (NameAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/createUserAccount")
    public String createAccount(CreateAccountRequest createAccountRequest){
        try{
            userService.register(createAccountRequest);
            return "User account created successfully";

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

    @PostMapping("/login/user")
    public String userLogin(@RequestBody LogInRequest logInRequest) throws LoginException {
        try{
            userService.login(logInRequest);
            return "successful";
        } catch (LoginException e) {
            throw new LoginException();
        }
    }

    @PostMapping("/findByTitle")
    public String findBookBy(@PathVariable String title){
        try{
            return "Book search was successfully" + " " + libraryService.findBookByTitle(title);
        } catch (NoBookFoundWIthTitleException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/uploadBook")
    public String putBookInLibrary(@PathVariable BookDto bookDto){
        try{
            return "Uploaded successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @PostMapping("/")
}
