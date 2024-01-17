package com.example.eagle.utils;
import com.example.eagle.data.models.Book;
import com.example.eagle.data.models.Creator;
import com.example.eagle.data.models.Library;
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

    public static void map(Book book, BookDto bookDto){
        book.setTitle(bookDto.getTitle());
        book.setCreator(bookDto.getCreator());
        book.setPage(bookDto.getPage());
        book.setContent(bookDto.getContent());
        book.setDate(bookDto.getDate());
    }
}
