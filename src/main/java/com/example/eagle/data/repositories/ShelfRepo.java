package com.example.eagle.data.repositories;

import com.example.eagle.data.models.Books;
import com.example.eagle.data.models.Shelf;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelfRepo extends MongoRepository<Shelf, String> {
//    Optional<Shelf> findByBooks(Books books);

    Optional<Books> findByTitle(String title);
}
