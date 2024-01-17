package com.example.eagle.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DeleteAccount {
    private String userName;
    private String password;
}
