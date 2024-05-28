package com.example.ProiectPS.Repositories;

import com.example.ProiectPS.Model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    Optional<Problem> findById(Long id);
    List<Problem> findAllByAddedDateAfter(LocalDateTime addedDate);

    @Query("SELECT p FROM Problem p where p not in (SELECT p FROM Problem p RIGHT JOIN Solving s ON p.id = s.idProblem where s.idUser = :userId) and p.name LIKE %:name%")
    List<Problem> findUnsolvedProblemsByName(@Param("name")String name, @Param("userId")long userId);

    @Query("SELECT p FROM Problem p RIGHT JOIN Solving s ON p.id = s.idProblem where s.idUser = :userId and s.score = 100")
    List<Problem> findSolvedProblems(@Param("userId")long userId);
    @Query("SELECT p FROM Problem p where p not in (SELECT p FROM Problem p RIGHT JOIN Solving s ON p.id = s.idProblem where s.idUser = :userId)")
    List<Problem> findUnsolvedProblems(@Param("userId")long userId);
    @Query("SELECT p FROM Problem p JOIN Solving s ON p.id = s.idProblem where s.idUser = :userId and s.score < 100 ORDER BY s.addedDate DESC")
    List<Problem> findRecentTriedProblems(@Param("userId")long userId);
}
