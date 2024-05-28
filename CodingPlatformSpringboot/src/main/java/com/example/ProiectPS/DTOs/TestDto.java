package com.example.ProiectPS.DTOs;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TestDto {
    private Long idProblem;
    private String input;
    private String output;


    public TestDto(Long idProblem, String input, String output) {

        super();
        this.idProblem = idProblem;
        this.input = input;
        this.output = output;
    }
}
