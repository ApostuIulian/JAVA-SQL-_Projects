package com.example.ProiectPS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String fullName;
    @Setter
    private String email;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private String role;
    @Setter
    private LocalDateTime addedDate;

    public User() {
        super();
    }

    public User(String fullName, String email, String username, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        addedDate = LocalDateTime.now();
    }

}
