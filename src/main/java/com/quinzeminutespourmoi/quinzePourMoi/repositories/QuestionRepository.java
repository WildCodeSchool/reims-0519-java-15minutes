package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
}