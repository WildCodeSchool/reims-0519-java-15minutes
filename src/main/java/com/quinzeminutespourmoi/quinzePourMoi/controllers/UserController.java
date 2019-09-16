package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("user", new User());
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public String store(HttpServletRequest request, String mail, String password, @ModelAttribute User user,
            @RequestParam(defaultValue = "false") boolean isHypnotherapist) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Long newId = userRepository.save(user).getId();

        try {
            request.login(mail, password);
        } catch (ServletException e) {
            logger.error("Error while login ", e);
        }

        if (isHypnotherapist) {
            return "redirect:/hypnoRegister";
        }
        return "redirect:/users" + newId;
    }

    @GetMapping("/users/{id}")
    public String read(Model model, Authentication authentication) {
        List<Hypnotherapist> hypnotherapists = hypnotherapistRepository.findAll();
        model.addAttribute("hypnotherapists", hypnotherapists);
        User user = userRepository.findByMail(authentication.getName());
        model.addAttribute("user", user);
        return "profileUser";
    }

}