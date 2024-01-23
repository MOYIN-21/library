package com.example.eagle.services;

import com.example.eagle.data.models.Reader;
import com.example.eagle.data.repositories.ReaderRepo;
import com.example.eagle.dtos.CreateAccountRequest;
import com.example.eagle.dtos.DeleteAccount;
import com.example.eagle.dtos.LogInRequest;
import com.example.eagle.exceptions.NameAlreadyExistException;
import com.example.eagle.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

import java.util.Optional;

import static com.example.eagle.utils.mapper.map;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderRepo readerRepo;
    @Override
    public String register(CreateAccountRequest createAccount) throws NameAlreadyExistException {
        Reader reader = new Reader();
        map(createAccount, reader);
        boolean foundUser = validateUserName(createAccount.getUserName());
        if (!foundUser) readerRepo.save(reader);
        return "Account created successfully";
    }

    @Override
    public boolean login(LogInRequest logInRequest) throws LoginException {
        Optional<Reader> foundUser = readerRepo.findByUserNameAndPassword(logInRequest.getUserName(), logInRequest.getPassword());
        if (foundUser.isPresent()) {
            return true;
        }
        throw new LoginException("Invalid Credentials");
    }

    private boolean validateUserName(String userName) throws NameAlreadyExistException {
        Optional<Reader> foundUser = readerRepo.findByUserName(userName);
        if (foundUser.isPresent()) {
            throw new NameAlreadyExistException("Username already exist");
        }
        return false;
    }

    public void deleteAll() {
        readerRepo.deleteAll();
    }

    @Override
    public String deleteAccount(DeleteAccount deleteAccount) throws UserNotFoundException {
            readerRepo.delete(findUser(deleteAccount.getUserName()));

        return "Account deleted successfully";
    }

    private Reader findUser(String userName) throws UserNotFoundException {
        Optional<Reader> user = readerRepo.findByUserName(userName);
        if(user.isEmpty()) throw new UserNotFoundException("User not Found");
        return null;
    }
}
