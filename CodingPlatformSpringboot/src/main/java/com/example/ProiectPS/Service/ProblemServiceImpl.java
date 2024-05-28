package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.ProblemDto;
import com.example.ProiectPS.Model.Problem;
import com.example.ProiectPS.Repositories.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;
    @Override
    public Problem save(ProblemDto problemDto) {
        Problem problem = new Problem(problemDto.getName(), problemDto.getTask(), problemDto.getDifficulty());
        return problemRepository.save(problem);
    }
    public Problem update(Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public void delete(Problem problem) {
        problemRepository.delete(problem);
    }


    @Override
    public List<Problem> findAll() {
        return problemRepository.findAll();
    }

    @Override
    public Optional<Problem> findById(Long id){return problemRepository.findById(id);}

    @Override
    public List<Problem> findRecentProblems() {
        LocalDateTime afterDate = LocalDateTime.now().minusDays(7);
        return  problemRepository.findAllByAddedDateAfter(afterDate);
    }

    @Override
    public List<Problem> findUnsolvedProblems(long userId) {
        return problemRepository.findUnsolvedProblems(userId);
    }

    @Override
    public List<Problem> findUnsolvedProblemsByName(String filter, long userId) {
        return problemRepository.findUnsolvedProblemsByName(filter, userId);
    }

    @Override
    public List<Problem> findSolvedProblems(long userId) {
        return problemRepository.findSolvedProblems(userId);
    }

    @Override
    public List<Problem> findRecentlyTriedProblems(long userId) {
        return problemRepository.findRecentTriedProblems(userId);
    }
}
