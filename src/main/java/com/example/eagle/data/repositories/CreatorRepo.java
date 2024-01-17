package com.example.eagle.data.repositories;

import com.example.eagle.data.models.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface CreatorRepo extends JpaRepository<Creator, Long> {
//    Creator findByUserName(String username);

//    Optional<User> findByUserNameAndPassword(String userName, String password);
}
