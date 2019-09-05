package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HypnotherapistController {

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;

    @GetMapping("/hypnotherapists")
    public String hypnotherapists(Model model) {
        model.addAttribute("hypnotherapists", hypnotherapistRepository.findAll());
        return "hypnotherapists";
    }

    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }
}