package com.example.eagle.dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookDto {
    private String title;
    private String creator;
    private LocalDate date;
    private String content;
    private int page;
}
