package com.quinzeminutespourmoi.quinzePourMoi.repositories;

import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
    Notification findNotificationByUserIdAndHypnotherapistId(Long userID, Long hypnotherapistID);
    List<Notification> findNotificationByUserIdOrHypnotherapistId(Long userID, Long hypnotherapistID);

}