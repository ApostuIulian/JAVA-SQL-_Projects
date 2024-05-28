package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.TestDto;
import com.example.ProiectPS.Model.Problem;
import com.example.ProiectPS.Model.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TestService {
    Test save(TestDto problemDto);
    Optional<Test> findById(Long id);

    List<Test> findByProblemId(Long idProblem);
    void delete(Test test);
}
