package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("user", new User());
        return "subscribe";
    }
    @PostMapping("/subscribe")
    public String store(@ModelAttribute User user, @RequestParam(defaultValue = "false") boolean isHypnotherapist) {
        user.setPassword(
            passwordEncoder.encode(
                user.getPassword()
            )
        );
        Long newId = userRepository.save(user).getId();
        if(isHypnotherapist){
            return "redirect:/hypnoRegister";
        }
        return "redirect:/users" + newId;
    }

    @GetMapping("/users/{id}")
    public String read(Model model, @PathVariable("id") Long userId) {
        User user = userRepository.findById(userId).get();
        model.addAttribute("user", user);
        return "profileUser";
    }
}
