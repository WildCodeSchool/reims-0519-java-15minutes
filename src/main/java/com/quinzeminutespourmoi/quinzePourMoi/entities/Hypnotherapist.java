package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Hypnotherapist extends User {

    public Hypnotherapist() {
    }

    public Hypnotherapist(User user) {
        super(user.getFirstname(), user.getLastname(), user.getPassword(), user.getMail(), user.getImage());
    }

    private String description;
    private String phone;
    private String address;
    private String adr_postal;
    private String town;

    @ManyToMany
    @JoinTable(
        name = "favorite", 
        joinColumns = @JoinColumn(name = "hypnotherapist_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> followers;

    @OneToMany(mappedBy = "hypnotherapist")
    private Set<Notification> notifications;

    @OneToMany(mappedBy ="hypnotherapist")
    private Set<Rate> rates;

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

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(super.getAuthorities());
        authorities.add(new SimpleGrantedAuthority("HYPNOTHERAPIST"));
        return authorities;
    }

    public Set<Rate> getRates() {
        return rates;
    }

    public void setRates(Set<Rate> rates) {
        this.rates = rates;
    }
}
