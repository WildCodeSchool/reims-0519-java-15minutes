package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Rate;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RateController{

    @Autowired
    private RateRepository rateRepository;

    @PostMapping
    public String store(Authentication authentication, int rate){
        rate.SetUser(User)authentication.getPrincipal();
        rate = rateRepository.save(rate);
        return "/infos";
    }

}