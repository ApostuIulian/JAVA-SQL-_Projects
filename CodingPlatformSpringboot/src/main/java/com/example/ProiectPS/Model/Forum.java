package com.example.ProiectPS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "forum", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
@Getter
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    @Column(columnDefinition = "TEXT")
    private String text;
    @Setter
    private String userName;
    @Setter
    private LocalDateTime addedDate;
    public Forum(String title, String text, String userName) {
        this.title = title;
        this.text = text;
        this.userName = userName;
        addedDate = LocalDateTime.now();
    }

    public Forum() {
        super();
    }
}
