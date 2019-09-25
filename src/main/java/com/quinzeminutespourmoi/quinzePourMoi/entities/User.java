package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

    public User() {
    }

    public User(String firstname, String lastname, String password, String mail, String role, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.role = role;
        this.image = image;
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
    private String image;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Hypnotherapist hypnotherapist;

    @ManyToMany (mappedBy = "followers")
    private Set<Hypnotherapist> likes;

    @OneToMany(mappedBy = "user")
    Set<Notification> notifications;



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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        if(hypnotherapist != null) {
            authorities.add(new SimpleGrantedAuthority("HYPNOTHERAPIST"));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return mail;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * @return String return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
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

    /**
     * @return Set<Hypnotherapist> return the likes
     */
    public Set<Hypnotherapist> getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(Set<Hypnotherapist> likes) {
        this.likes = likes;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

}
