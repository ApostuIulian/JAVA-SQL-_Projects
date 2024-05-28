package com.example.ProiectPS.Repositories;

import com.example.ProiectPS.Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAllByIdProblem(Long idProblem);
}
