package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

class SurveyController{

    @GetMapping("/survey/fear")
    public String fearsurvey(Model model){
        return "fear";
    }

    @GetMapping("/survey/fear/pets")
    public String pets(Model model){
        return "pets";
    }

    @GetMapping("/survey/fear/insects")
    public String insects(Model model){
        return "insects";
    }

    @GetMapping("/survey/fear/car")
    public String car(Model model){
        return "car";
    }

    @GetMapping("/survey/fear/plane")
    public String plane(Model model){
        return "plane";
    }

    @GetMapping("/survey/fear/people")
    public String people(Model model){
        return "people";
    }

    @GetMapping("/survey/fear/close")
    public String close(Model model){
        return "close";
    }

    @GetMapping("/survey/fear/water")
    public String water(Model model){
        return "water";
    }

    @GetMapping("/survey/addiction")
    public String addictionsurvey(Model model){
        return "addiction";
    }

    @GetMapping("/survey/addiction/food")
    public String food(Model model){
        return "food";
    }

    @GetMapping("/survey/addiction/alcohol")
    public String alcohol(Model model){
        return "alcohol";
    }

    @GetMapping("/survey/addiction/screen")
    public String screen(Model model){
        return "screen";
    }

    @GetMapping("/survey/smoke")
    public String smokesurvey(Model model){
        return "smoke";
    }
}