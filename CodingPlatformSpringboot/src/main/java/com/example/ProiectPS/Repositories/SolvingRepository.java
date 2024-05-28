package com.example.ProiectPS.Repositories;

import com.example.ProiectPS.Model.Solving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolvingRepository extends JpaRepository<Solving, Long> {
    List<Solving> findAllByIdProblem(Long idProblem);
    Solving findByIdProblemAndIdUser(Long idProblem, Long idUser);
}
