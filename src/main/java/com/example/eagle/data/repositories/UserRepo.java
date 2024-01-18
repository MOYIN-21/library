package com.example.eagle.data.repositories;

import com.example.eagle.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByUserNameAndPassword(String username, String password);
    Optional<User> findByUserName(String username);

}
