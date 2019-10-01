package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.RateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RateController{

    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;

    @GetMapping("/comment/{id}")
    public String comment(Model model, @PathVariable("id") Long hypnotherapistId){
        Hypnotherapist hypnotherapist = hypnotherapistRepository.findById(hypnotherapistId).get();
        model.addAttribute("hypnotherapist", hypnotherapist);
        return "comment";
    }

    @PostMapping("/comment/{id}")
    public String rate(Rate rating){
        rating = rateRepository.save(rating);
        return "redirect:/infos/"+rating.getHypnotherapist().getId();
    }
}


