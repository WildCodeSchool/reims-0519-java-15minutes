package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
    Favorite findFavoriteByUserIdAndHypnotherapistId(Long userID, Long hypnotherapistID);
    List<Favorite> findFavoriteByUserIdOrHypnotherapistId(Long userID, Long hypnotherapistID);
}