package com.example.eagle.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    private Long id;
    private String title;
    private String creator;
    private LocalDate date;
    private String content;
    private int page;

}
