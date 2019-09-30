package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rate {

    public Rate(){
    }
    
    public Rate(Long id, int rate){

        this.id = id;
        this.rate = rate;
    }

    @OneToMany(mappedBy= "rate")
    private Set<User>users;

    @OneToMany(mappedBy="rate")
    private Set<Hypnotherapist>hypnotherapists;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Hypnotherapist> getHypnotherapists() {
        return hypnotherapists;
    }

    public void setHypnotherapists(Set<Hypnotherapist> hypnotherapists) {
        this.hypnotherapists = hypnotherapists;
    }
}