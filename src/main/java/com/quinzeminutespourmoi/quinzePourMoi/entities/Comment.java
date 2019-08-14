package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment{
    public Comment(){
    }

    public Comment(String title, String content, Long hypnotherapist_id, Long user_id, Date date){
        this.title = title;
        this.content = content;
        this.hypnotherapist_id = hypnotherapist_id;
        this.user_id = user_id;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long hypnotherapist_id;
    private Long user_id;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
