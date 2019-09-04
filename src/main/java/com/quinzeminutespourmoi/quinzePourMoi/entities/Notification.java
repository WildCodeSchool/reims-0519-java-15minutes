package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification{

    public Notification() {
    }

    public Notification(Long hypnotherapistId, Long userId) {
        this.hypnotherapistId = hypnotherapistId;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hypnotherapistId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHypnotherapistId() {
        return hypnotherapistId;
    }

    public void setHypnotherapistId(Long hypnotherapistId) {
        this.hypnotherapistId = hypnotherapistId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
