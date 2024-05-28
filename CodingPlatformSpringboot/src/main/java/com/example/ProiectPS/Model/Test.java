package com.example.ProiectPS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Test")
@Getter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private Long idProblem;
    @Setter
    private String input;
    @Setter
    private String output;

    public Test(Long idProblem, String input, String output) {
        this.idProblem = idProblem;
        this.input = input;
        this.output = output;
    }

    public Test() {
        super();
    }
}
