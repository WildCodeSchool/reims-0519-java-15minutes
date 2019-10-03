package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Question{
    public Question(){
    }

    public Question(Long id, String title, String type, String category){
        this.id = id;
        this.title = title;
        this.type = type;
        this.category = category;
    }
    @Id
    private Long id;
    private String title;
    private String type;
    private String category;

    @OneToMany(mappedBy = "question")
    @OrderBy("answer DESC")
    private Set<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}