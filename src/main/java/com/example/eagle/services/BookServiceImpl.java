package com.example.eagle.services;
import com.example.eagle.data.models.Books;
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
        Books books = new Books();
        map(books, bookDto);
        shelfService.save(books);
        return "Book saved successfully";
    }

}
