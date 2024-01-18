package com.example.eagle.services;


import com.example.eagle.data.models.Books;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;

public interface ShelfService{
    Books findByBook_Title(String title) throws NoBookFoundWIthTitleException;

    String save(Books books);

    void deleteAll();

}
