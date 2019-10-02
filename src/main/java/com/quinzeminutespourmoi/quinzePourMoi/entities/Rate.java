package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rate {

    public Rate(){
    }
    
    public Rate(Long id, int rating){
        this.id = id;
        this.rating = rating;
    }

    @ManyToOne
    private User user;

    @ManyToOne
    private Hypnotherapist hypnotherapist;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hypnotherapist getHypnotherapist() {
        return hypnotherapist;
    }

    public void setHypnotherapist(Hypnotherapist hypnotherapist) {
        this.hypnotherapist = hypnotherapist;
    }
}