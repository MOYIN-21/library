package com.example.eagle.services;

import com.example.eagle.data.models.Book;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;

public interface LibraryService {
    String save(Book book);
    Book findBookByTitle(String title) throws NoBookFoundWIthTitleException;

    int getSize();
}
