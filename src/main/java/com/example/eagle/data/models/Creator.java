package com.example.eagle.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Creator {
    @Id
    private Long id;
    private String userName;
    private String password;
    @ManyToOne
    private Library library;
    @ManyToOne
    private Book book;
}
