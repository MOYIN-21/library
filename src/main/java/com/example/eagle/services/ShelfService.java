package com.example.eagle.services;


import com.example.eagle.data.models.Book;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;

public interface ShelfService{
    Book findByBook_Title(String title) throws NoBookFoundWIthTitleException;

    String save(Book book);

    void deleteAll();

}
