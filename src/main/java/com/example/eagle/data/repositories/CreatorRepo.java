package com.example.eagle.data.repositories;

import com.example.eagle.data.models.Creator;
import com.example.eagle.data.models.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreatorRepo extends MongoRepository<Creator, String> {
    Creator findByUserName(String username);

    Optional<Reader> findByUserNameAndPassword(String userName, String password);
}
