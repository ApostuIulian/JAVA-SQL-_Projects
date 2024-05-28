package com.example.ProiectPS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Solving")
@Getter
public class Solving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private Long idProblem;
    @Setter
    private int score;
    @Setter
    private Long idUser;
    @Setter
    private LocalDateTime addedDate;
    @Setter
    @Column(columnDefinition="TEXT")
    private String code;

    public Solving(Long idProblem, int score, Long idUser, String code) {
        this.idProblem = idProblem;
        this.idUser = idUser;
        this.score = score;
        this.code = code;
        this.addedDate = LocalDateTime.now();
    }

    public Solving() {
        super();
    }
}
