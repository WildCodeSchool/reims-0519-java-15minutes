package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Answer{
    public Answer(){
    }

    public Answer(Long id, String answer){
        this.id = id;
        this.answer = answer;
    }
    public Answer(Long id, String answer, Question question){
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    @Id
    private Long id;
    private String answer;


    @ManyToOne
    private Question question;

    @ManyToMany
    @JoinTable(
        name = "answer_user",
        joinColumns = @JoinColumn(name = "answer_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}