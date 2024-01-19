package com.example.eagle.data.models;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Creator {
    @Id
    private String id;
    private String userName;
    private String password;
    private Library library;
    private Books books;
}
