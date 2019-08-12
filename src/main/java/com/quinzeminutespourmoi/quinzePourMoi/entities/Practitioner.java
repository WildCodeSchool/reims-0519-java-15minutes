package com.quinzeminutespourmoi.quinzePourMoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Practitioner{
    public Practitioner(){
    }

    public Practitioner(String description, String phone, String mail,
    String adr_num, String adr_street, String adr_postal, String town){

        this.description = description;
        this.phone = phone;
        this.mail = mail;
        this.adr_num = adr_num;
        this.adr_street = adr_street;
        this.adr_postal = adr_postal;
        this.town = town;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String phone;
    private String mail;
    private String adr_num;
    private String adr_street;
    private String adr_postal;
    private String town;

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdr_num() {
        return adr_num;
    }

    public void setAdr_num(String adr_num) {
        this.adr_num = adr_num;
    }

    public String getAdr_street() {
        return adr_street;
    }

    public void setAdr_street(String adr_street) {
        this.adr_street = adr_street;
    }

    public String getAdr_postal() {
        return adr_postal;
    }

    public void setAdr_postal(String adr_postal) {
        this.adr_postal = adr_postal;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
