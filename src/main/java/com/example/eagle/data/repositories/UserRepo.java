package com.example.eagle.data.repositories;

import com.example.eagle.data.models.User;
import com.example.eagle.dtos.DeleteAccount;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
//    Optional<User> findByUserNameAndPassword(String username, String password);
//    Optional<User> findByUserName(String username);

}
