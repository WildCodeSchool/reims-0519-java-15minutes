package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import com.springbootapp.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<User> extends JpaRepository {
    User findByUsername(String username);
}