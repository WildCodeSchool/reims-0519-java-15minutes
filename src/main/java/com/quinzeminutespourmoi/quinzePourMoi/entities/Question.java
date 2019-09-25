package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question{
    public Question(){
    }

    public Question(Long id, String title){
        this.id = id;
        this.title = title;
    }
    @Id
    private Long id;
    private String title;

    @OneToMany(mappedBy = "question")
    private Set<Answer>answers;

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
}