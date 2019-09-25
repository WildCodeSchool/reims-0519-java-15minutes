package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class HypnotherapistController {

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }

    @PostMapping("/hypnoRegister")
    public String register(Authentication authentication, @RequestParam String description,
            @RequestParam String phone, @RequestParam String address, @RequestParam String adr_postal,
            @RequestParam String town) {
            User user = userRepository.findByMail(authentication.getName());
        hypnotherapistRepository.save(new Hypnotherapist(user, description, phone, address, adr_postal, town));
        return "home";
    }

    @GetMapping("/hypnoRegister")
    public String subscribe(Model model) {
        model.addAttribute("hypnotherapist", new Hypnotherapist());
        return "hypnoRegister";
    }

    @GetMapping("/hypnotherapists")
    public String hypnotherapists(Model model) {
        List<Hypnotherapist> hypnotherapists = hypnotherapistRepository.findAll();
        model.addAttribute("hypnotherapists", hypnotherapists);
        return "hypnotherapists";
    }

    @GetMapping("/hypnotherapists/{id}")
    public String HypnotherapistById (Model model, Authentication authentication, @PathVariable("id") Long hypnotherapistId) {
        Hypnotherapist hypnotherapist = hypnotherapistRepository.findById(hypnotherapistId).get();
        model.addAttribute("hypnotherapist", hypnotherapist);
        return "infos";
    }
}