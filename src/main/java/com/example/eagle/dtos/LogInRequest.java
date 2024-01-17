package com.example.eagle.dtos;

import lombok.Data;
//import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document("/login")
public class LogInRequest {
    private String userName;
    private String password;

}
