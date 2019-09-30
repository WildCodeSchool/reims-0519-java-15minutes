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
    private String userResponse;
    private String hypnotherapistResponse;

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

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }

    public String getHypnotherapistResponse() {
        return hypnotherapistResponse;
    }

    public void setHypnotherapistResponse(String hypnotherapistResponse) {
        this.hypnotherapistResponse = hypnotherapistResponse;
    }

    public Notification(User user, Hypnotherapist hypnotherapist, String userResponse, String hypnotherapistResponse) {
        this.user = user;
        this.hypnotherapist = hypnotherapist;
        this.userResponse = userResponse;
        this.hypnotherapistResponse = hypnotherapistResponse;
    }

    public Notification(Long id, User user, Hypnotherapist hypnotherapist, String userResponse,
            String hypnotherapistResponse) {
        this.id = id;
        this.user = user;
        this.hypnotherapist = hypnotherapist;
        this.userResponse = userResponse;
        this.hypnotherapistResponse = hypnotherapistResponse;
    }
}
