package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification{

    public Notification() {
    }

    public Notification(Long hypnotherapist_id, Long user_id) {
        this.hypnotherapist_id = hypnotherapist_id;
        this.user_id = user_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hypnotherapist_id;
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHypnotherapist_id() {
        return hypnotherapist_id;
    }

    public void setHypnotherapist_id(Long hypnotherapist_id) {
        this.hypnotherapist_id = hypnotherapist_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}