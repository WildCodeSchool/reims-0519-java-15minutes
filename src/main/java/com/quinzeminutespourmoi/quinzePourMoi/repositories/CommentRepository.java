package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
