package com.example.eagle.services;

import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.DeleteAccount;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.exceptions.UserNotFoundException;

import javax.security.auth.login.LoginException;

public interface ReaderService {
    String register(CreateAccountRequest createLibraryAccount) throws NameAlreadyExistException;

    boolean login(LogInRequest user) throws LoginException;
    void deleteAll();

    String deleteAccount(DeleteAccount deleteAccount) throws UserNotFoundException;
}
