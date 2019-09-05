package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class HypnotherapistController {

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;
    
    @GetMapping("/hypnotherapists") 
    public String hypnotherapists(Model model){
        model.addAttribute(
            "hypnotherapists",
            hypnotherapistRepository.findAll()
        );
        return "hypnotherapists";
    }
    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }


    @PostMapping("/subscribe/hypno")
    public Hypnotherapist subscribeHypno(@RequestParam String user, @RequestParam String description, @RequestParam String phone, @RequestParam String adr_num,
        @RequestParam String adr_street, @RequestParam String adr_postal, @RequestParam String town){
        return HypnotherapistRepository.save(new Hypnotherapist(user, description, phone, adr_num, adr_street, adr_postal, town));
    }
}