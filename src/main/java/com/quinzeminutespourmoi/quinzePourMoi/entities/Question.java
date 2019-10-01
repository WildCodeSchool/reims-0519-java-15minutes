package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question{
    public Question(){
    }

    public Question(Long id, String title, String type){
        this.id = id;
        this.title = title;
        this.type = type;
    }
    @Id
    private Long id;
    private String title;
    private String type;

    @OneToMany(mappedBy = "question")
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
}