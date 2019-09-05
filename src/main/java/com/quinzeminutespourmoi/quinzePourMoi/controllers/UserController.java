package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/subscribe")
    public String subscribe(Model model, Model model2) {
        model.addAttribute("user", new User());
        model2.addAttribute("hypnotherapist", new Hypnotherapist());
        return "subscribe";
    }

    
    @PostMapping("/subscribe")
    public User subscribe(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail,
            @RequestParam String password, @RequestParam String role) {
        return userRepository.save(new User(firstname, lastname, passwordEncoder.encode(password), mail, role));
    }

}
