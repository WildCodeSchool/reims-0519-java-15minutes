package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /*
    model.addAttribute("preSurvey", "preSurvey");
    @GetMapping("/questions")
    public String prepaQuest(@RequestParam Integer page, Model model) {
        if(page) { // sous-entendu page != null
            if(page.equals(1)) {
                return "";
            }
            if(page.equals(2)) {
                return "";
            }
            if(page.equals(3)) {
                return "";
            }
            if(page.equals(4)) {
                return "";
            }
            // les pages 2, 3... seront à rajouter ici
            if(page.equals(100)) {
                return "";
            }
            if(page.equals(101)) {
                return "";
            }
        }
        return "resultSurvey";
    } */
}