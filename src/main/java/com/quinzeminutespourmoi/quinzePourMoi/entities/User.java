package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    public User(String firstname, String lastname, String password, String mail, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Hypnotherapist hypnotherapist;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return String return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return Hypnotherapist return the hypnotherapist
     */
    public Hypnotherapist getHypnotherapist() {
        return hypnotherapist;
    }

    /**
     * @param hypnotherapist the hypnotherapist to set
     */
    public void setHypnotherapist(Hypnotherapist hypnotherapist) {
        this.hypnotherapist = hypnotherapist;
    }

}