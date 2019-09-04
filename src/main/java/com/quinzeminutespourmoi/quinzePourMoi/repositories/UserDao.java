package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}