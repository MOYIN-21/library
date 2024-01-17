package com.example.eagle.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Shelf {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;
    @OneToMany
    private List<Book> books = new ArrayList<>();
    private String title;

}
