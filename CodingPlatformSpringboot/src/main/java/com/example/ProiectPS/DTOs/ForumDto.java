package com.example.ProiectPS.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ForumDto {
    private String title;
    private String text;
    private String userName;
    private LocalDateTime addedDate;

    public ForumDto(String title, String text, String userName) {
        super();
        this.title = title;
        this.text = text;
        this.userName = userName;
    }

    public ForumDto()
    {}
}
