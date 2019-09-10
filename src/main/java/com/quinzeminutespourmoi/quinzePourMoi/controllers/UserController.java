package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String subscribe(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String mail,
            @RequestParam String password, @RequestParam String role, @RequestParam String image,@RequestParam(defaultValue = "false") boolean isHypnotherapist) {

        userRepository.save(new User(firstname, lastname, passwordEncoder.encode(password), mail, role, image));

        if(isHypnotherapist){
            return "redirect:/hypnoRegister";
        }
        return "redirect:/";
    }

    @PostMapping("/users")
    public String subscribe(@ModelAttribute User user) {
        System.out.println(user.getId());
        userRepository.save(user);
        return "redirect:/";
    }
}
