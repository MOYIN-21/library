package com.example.eagle.dtos;

import lombok.Data;

@Data
public class CreateAccountRequest {
    private String userName;
    private String password;

}
