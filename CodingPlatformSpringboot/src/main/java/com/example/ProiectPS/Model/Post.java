package com.example.ProiectPS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "post")
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private Long forumId;
    @Setter
    private String userName;
    @Setter
    @Column(columnDefinition = "TEXT")
    private String message;
    @Setter
    private LocalDateTime date;

    public Post(Long forumId, String userName, String message) {
        this.forumId = forumId;
        this.userName = userName;
        this.message = message;
        this.date = LocalDateTime.now();
    }

    public Post() {
        super();
    }
}
