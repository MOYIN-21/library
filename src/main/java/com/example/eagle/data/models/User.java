package com.example.eagle.data.models;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;
//import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document("/Users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @ManyToOne
    private Library library;
    @ManyToOne
    private Book book;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

