package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SurveyController{

    @GetMapping("/survey/smoke")
    public String smokesurvey(Model model){
        return "smokeSurvey";
    }

    @GetMapping("/survey/addiction")
    public String addictsurvey(Model model){
        return "addictSurvey";
    }

    @GetMapping("/survey/addiction/food")
    public String foodAddictionSurvey(Model model){
        return "foodAddictionSurvey";
    }

    @GetMapping("/survey/addiction/screen")
    public String screenAddictionSurvey(Model model){
        return "screenAddictionSurvey";
    }

    @GetMapping("/survey/addiction/alcohol")
    public String alcoholAddictionSurvey(Model model){
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/animals+insects")
    public String animalsFear(Model model){
        return "animalsFear";
    }

    @GetMapping("/survey/fear/car")
    public String carFear(Model model){
        return "carFear";
    }

    @GetMapping("/survey/fear/plane")
    public String planeFear(Model model){
        return "planeFear";
    }

    @GetMapping("/survey/fear/people")
    public String peopleFear(Model model){
        return "peopleFear";
    }

    @GetMapping("/survey/fear/water")
    public String waterFear(Model model){
        return "waterFear";
    }

    @GetMapping("/survey/fear/close")
    public String closeFear(Model model){
        return "closeFear";
    }

    @GetMapping("/survey/fear")
    public String fearSurvey(Model model){
        return "fearSurvey";
    }
}