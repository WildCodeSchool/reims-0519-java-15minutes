package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification{

    public Notification() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Hypnotherapist hypnotherapist;
    private Boolean userResponse;
    private Boolean hypnotherapistResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hypnotherapist getHypnotherapist() {
        return hypnotherapist;
    }

    public void setHypnotherapist(Hypnotherapist hypnotherapist) {
        this.hypnotherapist = hypnotherapist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(Boolean userResponse) {
        this.userResponse = userResponse;
    }

    public Boolean getHypnotherapistResponse() {
        return hypnotherapistResponse;
    }

    public void setHypnotherapistResponse(Boolean hypnotherapistResponse) {
        this.hypnotherapistResponse = hypnotherapistResponse;
    }

    public Notification(User user, Hypnotherapist hypnotherapist, Boolean userResponse, Boolean hypnotherapistResponse) {
        this.hypnotherapist = hypnotherapist;
        this.user = user;
        this.userResponse = userResponse;
        this.hypnotherapistResponse = hypnotherapistResponse;
    }

    public Notification(Long id, User user, Hypnotherapist hypnotherapist, Boolean userResponse,Boolean hypnotherapistResponse) {
        this.id = id;
        this.hypnotherapist = hypnotherapist;
        this.user = user;
        this.userResponse = userResponse;
        this.hypnotherapistResponse = hypnotherapistResponse;
    }
    
}
