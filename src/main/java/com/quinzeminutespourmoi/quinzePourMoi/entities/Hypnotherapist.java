package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hypnotherapist")
public class Hypnotherapist {
    
    public Hypnotherapist() {
    }

    public Hypnotherapist(User user, String description, String phone, String address,
            String adr_postal, String town) {

        this.user = user;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.adr_postal = adr_postal;
        this.town = town;
    }

    @Id
    @Column(name = "id")
    private Long id;
    private String description;
    private String phone;
    private String address;
    private String adr_postal;
    private String town;

    @OneToOne(optional = true)
    @MapsId
    private User user;

    @ManyToMany
    Set<User> likedHypno;


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
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * @return String return the adr_postal
     */
    public String getAdr_postal() {
        return adr_postal;
    }

    /**
     * @param adr_postal the adr_postal to set
     */
    public void setAdr_postal(String adr_postal) {
        this.adr_postal = adr_postal;
    }

    /**
     * @return String return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }


    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
