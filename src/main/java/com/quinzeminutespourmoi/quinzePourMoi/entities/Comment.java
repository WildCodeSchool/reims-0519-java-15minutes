package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment{
    public Comment(){
    }

    public Comment(String title, String content, int hypnotherapist_id, int user_id){
        this.title = title;
        this.content = content;
        this.hypnotherapist_id = hypnotherapist_id;
        this.user_id = user_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int hypnotherapist_id;
    private int user_id;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHypnotherapist_id() {
        return hypnotherapist_id;
    }

    public void setHypnotherapist_id(int hypnotherapist_id) {
        this.hypnotherapist_id = hypnotherapist_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
