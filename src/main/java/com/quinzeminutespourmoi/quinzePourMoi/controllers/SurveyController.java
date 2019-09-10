package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SurveyController{

    @GetMapping("/smokeSurvey")
    public String smokesurvey(Model model){
        return "smokesurvey";
    }
}