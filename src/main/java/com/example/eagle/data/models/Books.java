package com.example.eagle.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Books {
    @Id
    private String id;
    private String book_title;
    private String creator;
    private LocalDate date;
    private String content;
    private int page;

}
