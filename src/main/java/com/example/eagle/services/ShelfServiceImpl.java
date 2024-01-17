package com.example.eagle.services;

import com.example.eagle.data.models.Book;
import com.example.eagle.data.models.Shelf;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import com.example.eagle.services.ShelfService;
import org.springframework.stereotype.Service;

//package com.example.eagle.services;
//
//import com.example.eagle.data.models.Book;
//import com.example.eagle.data.models.Shelf;
//import com.example.eagle.data.repositories.ShelfRepo;
//import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
@Service
//@AllArgsConstructor
public class ShelfServiceImpl implements ShelfService {
////    @Autowired
//    private final ShelfRepo shelfRepo;
    @Override
    public Book findByBook_Title(String title) throws NoBookFoundWIthTitleException {
//        Optional<Book> foundBook = shelfRepo.findByBook_Title(title);
//        if (foundBook.isPresent()){
//            Book book = foundBook.get();
//        if (title.equalsIgnoreCase(book.getTitle())){
//            return book;}
//        }

        throw  new NoBookFoundWIthTitleException("Book not found");
    }
//
    @Override
    public String save(Book book) {
//        Shelf shelf = new Shelf();
//        shelf.setBooks(book);
//        shelf.setTitle(book.getTitle());
//        shelfRepo.save(shelf);
        return "Book saved successfully";
    }
//
    @Override
    public void deleteAll() {
//        shelfRepo.deleteAll();
    }
}
