package com.example.eagle.services;
import com.example.eagle.data.models.Creator;
import com.example.eagle.data.models.User;
import com.example.eagle.data.repositories.CreatorRepo;
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
public class CreatorServiceImpl implements CreatorService{
    @Autowired
    private CreatorRepo creatorRepo;

    @Override
    public void deleteAll() {
        creatorRepo.deleteAll();

    }

    @Override
    public String register(CreateAccountRequest creatorUserName) throws NameAlreadyExistException {
        Creator creator = new Creator();
        map(creatorUserName, creator);
        boolean foundCreator = validateCreatorUserName(creatorUserName.getUserName());
        if (!foundCreator) creatorRepo.save(creator);
        return "Account for Creator created successfully";
    }

    @Override
    public boolean login(LogInRequest creator) throws LoginException {
//        Optional<User> foundUser = creatorRepo.findByUserNameAndPassword(creator.getUserName(), creator.getPassword());
//        if (foundUser.isPresent()) {
//            return true;
//        }
        throw new LoginException("Invalid Credentials");
    }

    @Override
    public String deleteAccount(DeleteAccount deleteAccount) throws UserNotFoundException {
        creatorRepo.delete(findUser(deleteAccount.getUserName()));
        return "Account deleted successfully";
    }

    private Creator findUser(String userName) throws UserNotFoundException {
//        Creator creator = creatorRepo.findByUserName(userName);
//        if(creator.isEmpty()) throw new UserNotFoundException("creator not Found");
        return null;
    }


    private boolean validateCreatorUserName(String userName) throws NameAlreadyExistException {
//        Creator foundCreator = creatorRepo.findByUserName(userName);
//        if (foundCreator.isPresent()) {
//            throw new NameAlreadyExistException("Username already exist");
//        }
        return false;
    }
}
