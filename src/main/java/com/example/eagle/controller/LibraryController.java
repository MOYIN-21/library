package com.example.eagle.controller;

import com.example.eagle.dtos.BookDto;
import com.example.eagle.exceptions.NoBookFoundWIthTitleException;
import com.example.eagle.services.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @PostMapping("/findByTitle")
    public String findBookBy(@PathVariable String title){
        try{
            return "Book search was successfully" + " " + libraryService.findBookByTitle(title);
        } catch (NoBookFoundWIthTitleException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/uploadBook")
    public String putBookInLibrary(@PathVariable BookDto bookDto){
        try{
            return "Uploaded successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @PostMapping("/")
}
