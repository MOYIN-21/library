package com.example.eagle.services;

import com.example.eagle.data.models.Books;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;

public interface LibraryService {
    String save(Books books);
    Books findBookByTitle(String title) throws NoBookFoundWIthTitleException;

    int getSize();
}
