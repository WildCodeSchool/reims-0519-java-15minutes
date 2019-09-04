package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HypnotherapistController {

    @GetMapping("/hypnotherapists") 
    public String hypnotherapists(Model model){
        return "hypnotherapists";
    }
    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }
}