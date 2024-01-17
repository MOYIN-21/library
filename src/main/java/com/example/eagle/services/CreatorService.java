package com.example.eagle.services;
import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.DeleteAccount;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.exceptions.UserNotFoundException;

import javax.security.auth.login.LoginException;

public interface CreatorService {
    void deleteAll();

    String register(CreateAccountRequest creatorUserName) throws NameAlreadyExistException;

    boolean login(LogInRequest creator) throws LoginException;

    String deleteAccount(DeleteAccount deleteAccount) throws UserNotFoundException;

}
