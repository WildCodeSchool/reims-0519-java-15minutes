package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;

@Repository
public interface HypnotherapistRepository extends JpaRepository<Hypnotherapist, Long> {
    public Hypnotherapist findByUser(String user);

}