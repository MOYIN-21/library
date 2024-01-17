package com.example.eagle.services;
import com.example.eagle.data.models.Book;
import com.example.eagle.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.example.eagle.utils.mapper.map;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private ShelfService shelfService;

    @Override
    public String writeBook(BookDto bookDto) {
        Book book = new Book();
        map(book, bookDto);
        shelfService.save(book);
        return "Book saved successfully";
    }

}
