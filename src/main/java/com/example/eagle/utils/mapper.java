package com.example.eagle.utils;
import com.example.eagle.data.models.Books;
import com.example.eagle.data.models.Creator;
import com.example.eagle.data.models.User;
import com.example.eagle.dtos.BookDto;
import com.example.eagle.dtos.CreateAccountRequest;

public class mapper {
    public static void map(CreateAccountRequest createAccount, User user){
        user.setUserName(createAccount.getUserName());
        user.setPassword(createAccount.getPassword());
    }

    public static void map(CreateAccountRequest createAccount, Creator creator){
        creator.setUserName(createAccount.getUserName());
        creator.setPassword(createAccount.getPassword());
    }

    public static void map(Books books, BookDto bookDto){
        books.setTitle(bookDto.getTitle());
        books.setCreator(bookDto.getCreator());
        books.setPage(bookDto.getPage());
        books.setContent(bookDto.getContent());
        books.setDate(bookDto.getDate());
    }
}
