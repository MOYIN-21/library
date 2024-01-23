package com.example.eagle.data.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("/Users")
public class Reader {
    @Id
    private String id;
    private String userName;
    private String password;
    private Library library;
    private Books books;

}
