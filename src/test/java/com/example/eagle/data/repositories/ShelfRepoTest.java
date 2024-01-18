//package com.example.eagle.data.repositories;
//
//import com.example.eagle.data.models.Books;
//import com.example.eagle.data.models.Shelf;
//import com.example.eagle.exceptions.NameAlreadyExistException;
//import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.security.auth.login.LoginException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@SpringBootTest
//class ShelfRepoTest {
//
//    @Autowired
//    private ShelfRepo shelfRepo;
//    @Test
//    void findByBookTitleTest() throws NameAlreadyExistException, LoginException, NoBookFoundWIthTitleException {
//        Books book = new Books();
//        book.setBook_title("Fire");
//        book.setCreator("Miss. Law");
//        book.setPage(10);
//        book.setContent("Once upon a time ");
//        book.setDate(LocalDate.ofEpochDay(21/10/2008));
//
//        Shelf shelf = new Shelf();
//        List<Books> books = new ArrayList<>();
//        books.add(book);
//        shelf.setBooks(books);
//        var savedShelf = shelfRepo.save(shelf);
//
//        assertEquals("Fire", shelfRepo.findByBooks(book).orElseThrow().getTitle());
//
//    }
//}