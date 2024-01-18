package com.example.eagle.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Shelf {
    @Id
    private String Id;
    private Books books;
    private String title;

}
