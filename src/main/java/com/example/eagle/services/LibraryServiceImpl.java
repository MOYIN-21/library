package com.example.eagle.services;

import com.example.eagle.data.models.Books;
import com.example.eagle.data.models.Library;
import com.example.eagle.data.models.Shelf;
import com.example.eagle.data.repositories.LibraryRepo;
import com.example.eagle.data.repositories.ShelfRepo;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepo libraryRepo;
    @Autowired
    private ShelfService shelfService;
    @Autowired
    ShelfRepo shelfRepo;


    @Override
    public String save(Books books) {
        Library library = new Library();
        Shelf shelf = new Shelf();
        shelf.setBooks(books);
        library.setShelf(shelf);
        libraryRepo.save(library);
        return "Book saved successfully";

    }

    @Override
    public Books findBookByTitle(String title) throws NoBookFoundWIthTitleException {


//        for (Shelf shelf : shelfRepo.findAll()) {
//            for (Books books : shelf.) {
//                if (title.equalsIgnoreCase(books.getTitle())){
//                    return books;
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
