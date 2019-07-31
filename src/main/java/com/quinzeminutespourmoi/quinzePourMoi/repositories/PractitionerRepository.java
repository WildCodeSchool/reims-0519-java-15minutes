package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Practitioner;

@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
}