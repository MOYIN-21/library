package com.example.eagle.services;

import com.example.eagle.data.models.User;
import com.example.eagle.data.repositories.LibraryRepo;
import com.example.eagle.data.repositories.UserRepo;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public String register(CreateAccountRequest createAccount) throws NameAlreadyExistException {
        User user = new User();
        map(createAccount, user);
        boolean foundUser = validateUserName(createAccount.getUserName());
        if (!foundUser) userRepo.save(user);
        return "Account created successfully";
    }

    @Override
    public boolean login(LogInRequest logInRequest) throws LoginException {
//        Optional<User> foundUser = userRepo.findByUserNameAndPassword(logInRequest.getUserName(), logInRequest.getPassword());
//        if (foundUser.isPresent()) {
//            return true;
//        }
        throw new LoginException("Invalid Credentials");
    }

    private boolean validateUserName(String userName) throws NameAlreadyExistException {
//        Optional<User> foundUser = userRepo.findByUserName(userName);
//        if (foundUser.isPresent()) {
//            throw new NameAlreadyExistException("Username already exist");
//        }
        return false;
    }

    public void deleteAll() {
        userRepo.deleteAll();
    }

    @Override
    public String deleteAccount(DeleteAccount deleteAccount) throws UserNotFoundException {
            userRepo.delete(findUser(deleteAccount.getUserName()));

        return "Account deleted successfully";
    }

    private User findUser(String userName) throws UserNotFoundException {
//        Optional<User> user = userRepo.findByUserName(userName);
//        if(user.isEmpty()) throw new UserNotFoundException("User not Found");
        return null;
    }
}
