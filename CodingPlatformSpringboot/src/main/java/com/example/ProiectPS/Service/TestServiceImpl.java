package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.TestDto;
import com.example.ProiectPS.Model.Test;
import com.example.ProiectPS.Repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestRepository testRepository;

    @Override
    public Test save(TestDto testDto) {
        Test test = new Test(testDto.getIdProblem(), testDto.getInput(), testDto.getOutput());
        return testRepository.save(test);
    }
    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public List<Test> findByProblemId(Long idProblem) {
        return (List<Test>) testRepository.findAllByIdProblem(idProblem);
    }

    public void delete(Test test)
    {
        testRepository.delete(test);
    }

}
