package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.RateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RateController{

    @Autowired
    private RateRepository rateRepository;

    @GetMapping("/comment")
    public String comment(Model model){
        return "comment";
    }

    @PostMapping("/comment")
    public String rate(Rate rating){
        rating = rateRepository.save(rating);
        return "redirect:/infos/";
    }

}
