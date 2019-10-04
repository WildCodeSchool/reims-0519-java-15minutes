package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
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
    private Double lat;
    private Double lng;

    @OneToMany(mappedBy = "hypnotherapist")
    private Set<Notification> notifications;

    @OneToMany(mappedBy ="hypnotherapist")
    private Set<Rate> rates;

    @OneToMany(mappedBy = "hypnotherapist")
    Set<Favorite> favorites;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }
    
    public Set<Rate> getRates() {
        return rates;
    }

    public void setRates(Set<Rate> rates) {
        this.rates = rates;
    }
    
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
		this.lng = lng;
    }
}

