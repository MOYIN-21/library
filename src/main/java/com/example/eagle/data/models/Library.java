package com.example.eagle.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("/library")
public class Library {
    @Id
    private String id;
    private Shelf shelf;
    private User users;
    private Creator creator;
}
