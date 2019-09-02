package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PageController {

    @GetMapping("/")
    public String intro(Model model) {
        return "intro";
    }

    @GetMapping("/preSurvey")
    public String preSurvey(Model model) {
        return "preSurvey";
    }

    @GetMapping("/choices")
    public String choices(Model model) {
        return "choices";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        return "about-us";
    }

    @GetMapping("/resultSurvey")
    public String resultSurvey(Model model) {
        return "resultSurvey";
    }

    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }
}