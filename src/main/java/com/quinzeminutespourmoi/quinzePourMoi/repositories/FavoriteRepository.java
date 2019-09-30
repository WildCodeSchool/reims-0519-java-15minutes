package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
    Favorite findFavoriteByUserIdAndHypnotherapistId(Long userID, Long hypnotherapistID);
    Favorite findFavoriteByUserId(Long userId);
}