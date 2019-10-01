package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favorite{

    public Favorite(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Hypnotherapist hypnotherapist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Favorite(User user, Hypnotherapist hypnotherapist) {
        this.user = user;
        this.hypnotherapist = hypnotherapist;
    }

    public Favorite(Long id, User user, Hypnotherapist hypnotherapist) {
        this.id = id;
        this.user = user;
        this.hypnotherapist = hypnotherapist;
    }
}