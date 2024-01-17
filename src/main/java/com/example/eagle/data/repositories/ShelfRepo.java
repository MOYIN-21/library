package com.example.eagle.data.repositories;

import com.example.eagle.data.models.Book;
import com.example.eagle.data.models.Shelf;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//@Repository
public interface ShelfRepo extends JpaRepository<Shelf, Long> {

    @Query("select s from Shelf s where :book IN s.books")
    Optional<Shelf> findByBook(Book book);

}
