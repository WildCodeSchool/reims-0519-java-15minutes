package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query(
        value = "SELECT avg(rating) AS average FROM quinze_db.rate GROUP BY hypnotherapist_id",
        nativeQuery = true
    ) 
    Rate findByHypnotherapistId(int id);
}