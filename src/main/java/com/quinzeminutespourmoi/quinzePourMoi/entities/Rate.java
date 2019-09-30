package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rate {

    public Rate(){
    }
    
    public Rate(Long id, int rate){
        this.id = id;
        this.rate = rate;
    }

    @ManyToOne
    private Rate rates;

    @Id
    private Long id;
    private int rate;

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
}