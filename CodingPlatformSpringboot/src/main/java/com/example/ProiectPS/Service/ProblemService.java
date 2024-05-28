package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.ProblemDto;
import com.example.ProiectPS.Model.Problem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface ProblemService {
    Problem save(ProblemDto problemDto);
    Problem update(Problem problem);
    void delete(Problem problem);
    List<Problem> findAll();
    Optional<Problem> findById(Long id);

    List<Problem> findRecentProblems();

    List<Problem> findUnsolvedProblems(long userId);
    List<Problem> findUnsolvedProblemsByName(String filter, long userId);
    List<Problem> findSolvedProblems(long userId);
    List<Problem> findRecentlyTriedProblems(long userId);
}
