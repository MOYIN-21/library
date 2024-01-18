package com.example.eagle.data.repositories;

import com.example.eagle.data.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepo extends MongoRepository<Library, String> {
}
