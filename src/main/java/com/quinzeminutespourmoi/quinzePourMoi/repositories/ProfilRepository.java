package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long>{
}