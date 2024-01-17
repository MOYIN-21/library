package com.example.eagle.services;

import com.example.eagle.data.models.Book;
import com.example.eagle.data.models.Library;
import com.example.eagle.data.models.Shelf;
import com.example.eagle.data.repositories.LibraryRepo;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {
//    @Autowired
    private final LibraryRepo libraryRepo;
    @Autowired
    private ShelfService shelfService;


    @Override
    public String save(Book book) {
        Library library = new Library();
//        Shelf shelf = new Shelf();
//        shelf.setBooks(book);
//        library.setShelf(shelf);
//        libraryRepo.save(library);
        return "Book saved successfully";

    }

    @Override
    public Book findBookByTitle(String title) throws NoBookFoundWIthTitleException {


//        for (Shelf shelf : shelfRepo.findAll()) {
//            for (Book book : shelf.getBooks()) {
//                if (title.equalsIgnoreCase(book.getTitle())){
//                    return book;
//                }
//            }
//        }
        throw new NoBookFoundWIthTitleException("No book found with title");
    }

    @Override
    public int getSize() {
        int num = (int) libraryRepo.count();
        return num;
    }
}
