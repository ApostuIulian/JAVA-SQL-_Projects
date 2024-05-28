package com.example.ProiectPS.DTOs;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProblemDto {
    private String name;
    private String task;
    private String difficulty;

    public ProblemDto(String name, String task, String difficulty) {
        super();
        this.name = name;
        this.task = task;
        this.difficulty = difficulty;
    }
}
