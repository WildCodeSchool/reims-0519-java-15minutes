package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;

@Controller
class HypnotherapistController {

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hypnotherapists")
    public String hypnotherapists(Model model) {
        model.addAttribute("hypnotherapists", hypnotherapistRepository.findAll());
        return "hypnotherapists";
    }

    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }

    @PostMapping("/hypnoRegister")
    public Hypnotherapist register(Authentication authentication, @RequestParam String description,
            @RequestParam String phone, @RequestParam String adr_street, @RequestParam String adr_postal,
            @RequestParam String town) {
            System.out.println(authentication.getPrincipal());
            User user = userRepository.findByMail(authentication.getName());
            System.out.println("-------------------------------");
            System.out.println(user.getUsername());
            System.out.println("-------------------------------");

        return hypnotherapistRepository.save(new Hypnotherapist(user, description, phone, adr_street, adr_postal, town));
    }

    @GetMapping("/hypnoRegister")
    public String subscribe(Model model) {
        model.addAttribute("hypnotherapist", new Hypnotherapist());
        return "hypnoRegister";
    }
}