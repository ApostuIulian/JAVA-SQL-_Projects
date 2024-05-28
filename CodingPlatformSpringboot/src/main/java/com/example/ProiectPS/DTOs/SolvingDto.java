package com.example.ProiectPS.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class SolvingDto {
    private Long idProblem;
    private int score;
    private Long idUser;
    private String code;
    private LocalDateTime addedDate;


    public SolvingDto(Long idProblem, Long idUser) {
        super();
        this.idProblem = idProblem;
        this.idUser = idUser;
    }
}
