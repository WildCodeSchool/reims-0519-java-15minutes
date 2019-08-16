package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class AccountController{

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registerValid")
    public User create(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String password,@RequestParam String mail,@RequestParam String role){
        return userRepository.save(
            new User(firstname, lastname, password, mail, role)
        );
    }
}