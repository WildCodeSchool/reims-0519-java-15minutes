package com.quinzeminutespourmoi.quinzePourMoi.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

    public User() {
    }

    public User(String firstname, String lastname, String password, String mail, String role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
    } */
    

    @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       if(getMail().equals(mail)) {
           authorities.add(new SimpleGrantedAuthority("ADMIN"));
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
}
