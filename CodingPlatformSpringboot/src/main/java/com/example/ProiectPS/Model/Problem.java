package com.example.ProiectPS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "problems", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Getter
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    @Column(columnDefinition="TEXT")
    private String task;
    @Setter
    private String difficulty;
    @Setter
    @Column(name = "addedDate", nullable = false, updatable = false)
    private LocalDateTime addedDate;
    @Setter
    @OneToMany(mappedBy = "idProblem") // Mapped by "problem" field in Solving
    private List<Solving> solvings;
    @Setter
    @OneToMany(mappedBy = "idProblem") // Mapped by "problem" field in Solving
    private List<Test> tests;

    public Problem(String name, String task, String difficulty) {
        this.name = name;
        this.task = task;
        this.difficulty = difficulty;
        addedDate = LocalDateTime.now();
        solvings = new ArrayList<>();
    }

    public Problem() {
        super();
    }
}
