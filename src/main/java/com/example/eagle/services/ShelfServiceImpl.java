package com.example.eagle.services;

import com.example.eagle.data.models.Books;
import com.example.eagle.data.models.Shelf;
import com.example.eagle.data.repositories.ShelfRepo;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ShelfServiceImpl implements ShelfService {
    private final ShelfRepo shelfRepo;
    @Override
    public Books findByBook_Title(String title) throws NoBookFoundWIthTitleException {
        Optional<Books> foundBook = shelfRepo.findByBook_Title(title);
        if (foundBook.isPresent()){
            Books books = foundBook.get();
        if (title.equalsIgnoreCase(books.getBook_title())){
            return books;}
        }

        throw  new NoBookFoundWIthTitleException("Book not found");
    }

    @Override
    public String save(Books books) {
        Shelf shelf = new Shelf();
        shelf.setBooks(books);
        shelf.setTitle(books.getBook_title());
        shelfRepo.save(shelf);
        return "Book saved successfully";
    }

    @Override
    public void deleteAll() {
        shelfRepo.deleteAll();
    }
}
