package com.example.ProiectPS.Repositories;

import com.example.ProiectPS.Model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {

    Optional<Forum> findById(Long id);

    @Query("SELECT f FROM Forum f where f.title LIKE %:title%")
    List<Forum> findForumByName(@Param("title")String title);
}
