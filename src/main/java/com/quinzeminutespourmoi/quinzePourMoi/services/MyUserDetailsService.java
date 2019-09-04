package com.quinzeminutespourmoi.quinzePourMoi.services;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
   
   @Autowired
   private UserRepository userRepository;

   @Autowired
   PasswordEncoder passwordEncoder;

   @Override
   public UserDetails loadUserByUsername(String mail) {       
       User user = userRepository.findByMail(mail);
       if (user == null) {
           throw new UsernameNotFoundException(mail);
       }
       return user;
   }
}