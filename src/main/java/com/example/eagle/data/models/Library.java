package com.example.eagle.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;


@Data
//@Document("/library")
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Library {
    @Id
    private Long id;
    @OneToOne
    private Shelf shelf;
    @ManyToOne
    private User users;
    @ManyToOne
    private Creator creator;
}
