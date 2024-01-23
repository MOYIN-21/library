package com.example.eagle.data.repositories;

import com.example.eagle.data.models.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReaderRepo extends MongoRepository<Reader, String> {
    Optional<Reader> findByUserNameAndPassword(String username, String password);
    Optional<Reader> findByUserName(String username);

}
