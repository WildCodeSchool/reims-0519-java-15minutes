package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByMail(String mail);
}