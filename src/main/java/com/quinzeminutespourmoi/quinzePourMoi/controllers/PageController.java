package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PageController {

    @GetMapping("/")
    public String intro(Model model) {
        return "home";
    }

    @GetMapping("/home")
    public String preSurvey(Model model) {
        return "preSurvey";
    }

    @GetMapping("/survey")
    public String choices(Model model) {
        return "choices";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        return "about-us";
    }

    @GetMapping("/survey/result")
    public String resultSurvey(Model model) {
        return "resultSurvey";
    }

    @GetMapping("/comment")
    public String comment(Model model){
        return "comment";
    }

}
