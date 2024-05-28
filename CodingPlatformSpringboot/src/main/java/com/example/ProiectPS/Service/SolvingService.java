package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.ProblemDto;
import com.example.ProiectPS.DTOs.SolvingDto;
import com.example.ProiectPS.Model.Problem;
import com.example.ProiectPS.Model.Solving;
import com.example.ProiectPS.Model.Test;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface SolvingService {
    Solving save(SolvingDto solvingDto);
    Solving update(Solving solving);
    void delete(Solving solving);

    List<Solving> findByProblemId(Long idProblem);
    Solving findSpecificSolving(Long idProblem, Long idUser);
}
