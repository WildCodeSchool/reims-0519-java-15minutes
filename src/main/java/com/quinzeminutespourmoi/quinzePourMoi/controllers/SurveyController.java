package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SurveyController{

    @GetMapping("/smokeSurvey")
    public String smokesurvey(Model model){
        return "smokeSurvey";
    }

    @GetMapping("/addictSurvey")
    public String addictsurvey(Model model){
        return "addictSurvey";
    }

    @GetMapping("/foodAddictionSurvey")
    public String foodAddictionSurvey(Model model){
        return "foodAddictionSurvey";
    }

    @GetMapping("/screenAddictionSurvey")
    public String screenAddictionSurvey(Model model){
        return "screenAddictionSurvey";
    }

    @GetMapping("/alcoolAddictionSurvey")
    public String alcoolAddictionSurvey(Model model){
        return "alcoolAddictionSurvey";
    }

    @GetMapping("/animalsFear")
    public String animalsFear(Model model){
        return "animalsFear";
    }

    @GetMapping("/carFear")
    public String carFear(Model model){
        return "carFear";
    }

    @GetMapping("/planeFear")
    public String planeFear(Model model){
        return "planeFear";
    }

    @GetMapping("/peopleFear")
    public String peopleFear(Model model){
        return "peopleFear";
    }

    @GetMapping("/waterFear")
    public String waterFear(Model model){
        return "waterFear";
    }

    @GetMapping("/closeFear")
    public String closeFear(Model model){
        return "closeFear";
    }
}