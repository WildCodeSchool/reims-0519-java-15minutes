package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate{
    public Rate(){
    }

    public Rate(int rate, Long hypnotherapistId, Long userId){
        this.rate = rate;
        this.hypnotherapistId = hypnotherapistId;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private Long hypnotherapistId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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