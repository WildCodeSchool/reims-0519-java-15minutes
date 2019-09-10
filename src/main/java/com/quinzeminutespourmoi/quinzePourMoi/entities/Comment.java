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

    public Comment(String title, String content, Long hypnotherapistId, Long userId, Date CreationDate){
        this.title = title;
        this.content = content;
        this.hypnotherapistId = hypnotherapistId;
        this.userId = userId;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long hypnotherapistId;
    private Long userId;
    private Date creationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = creationDate;
    }
}
