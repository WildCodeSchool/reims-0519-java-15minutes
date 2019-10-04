package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query(
        value = "SELECT avg(rating) FROM rate GROUP BY hypnotherapist_id",
        nativeQuery = true
    ) 
	List<Rate>findByHypnotherapistId(Long hypnotherapistId);
}