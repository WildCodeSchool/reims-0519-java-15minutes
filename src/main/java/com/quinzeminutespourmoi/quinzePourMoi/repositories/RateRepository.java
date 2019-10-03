package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    Rate findByHypnotherapistId(Long id, Long hypnotherapistId);

    @Query(
        value = "SELECT avg(rating) AS average FROM quinze_db.rate GROUP BY hypnotherapist_id",
        nativeQuery = true
    ) 
    List<Rate> findByHypnotherapistId(@Param("hypnotherapist_id") int id);
}