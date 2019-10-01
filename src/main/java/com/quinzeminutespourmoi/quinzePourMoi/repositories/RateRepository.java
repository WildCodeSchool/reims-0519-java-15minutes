package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}