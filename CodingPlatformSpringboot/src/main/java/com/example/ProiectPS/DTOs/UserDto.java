package com.example.ProiectPS.DTOs;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String role;


    public UserDto(String fullName, String email, String username, String password, String role) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
