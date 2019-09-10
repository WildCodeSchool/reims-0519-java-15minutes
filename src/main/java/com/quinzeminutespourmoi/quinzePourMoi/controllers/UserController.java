package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("user", new User());
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public User subscribe(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail,
            @RequestParam String password, @RequestParam String role, @RequestParam String image) {
        return userRepository.save(new User(firstname, lastname, password, mail, role, image));

    }

}
