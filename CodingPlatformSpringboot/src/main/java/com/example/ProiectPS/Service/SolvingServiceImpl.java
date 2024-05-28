package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.SolvingDto;
import com.example.ProiectPS.Model.Solving;
import com.example.ProiectPS.Model.Test;
import com.example.ProiectPS.Repositories.SolvingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SolvingServiceImpl implements SolvingService{
    @Autowired
    SolvingRepository solvingRepository;
    @Override
    public Solving save(SolvingDto solvingDto) {
        Solving solving = new Solving(solvingDto.getIdProblem(), solvingDto.getScore(), solvingDto.getIdUser(), solvingDto.getCode());
        return solvingRepository.save(solving);
    }

    @Override
    public Solving update(Solving solving) {
        return solvingRepository.save(solving);
    }

    @Override
    public void delete(Solving solving) {
         solvingRepository.delete(solving);
    }

    @Override
    public List<Solving> findByProblemId(Long idProblem) {
        return (List<Solving>) solvingRepository.findAllByIdProblem(idProblem);    }

    @Override
    public Solving findSpecificSolving(Long idProblem, Long idUser) {
        return solvingRepository.findByIdProblemAndIdUser(idProblem, idUser);
    }


}
