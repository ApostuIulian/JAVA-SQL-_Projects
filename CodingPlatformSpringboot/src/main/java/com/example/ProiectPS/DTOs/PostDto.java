package com.example.ProiectPS.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long forumId;
    private String userName;
    private String message;

    public PostDto(Long forumId, String userName, String message) {
        super();
        this.forumId = forumId;
        this.userName = userName;
        this.message = message;
    }

    public PostDto()
    {}
    private LocalDateTime date;
}
