package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("user", new User());
        return "subscribe";
    }

    @PostMapping("/users")
    public String store(@ModelAttribute User user) {
        Long newId = userRepository.save(user).getId();
        return "redirect:/users/" + newId;
    }

    @GetMapping("/users/{id}")
    public String read(Model model, @PathVariable("id") Long userId) {
        User user = userRepository.findById(userId).get();
        model.addAttribute("user", user);
        return "profileUser";
    }

}
