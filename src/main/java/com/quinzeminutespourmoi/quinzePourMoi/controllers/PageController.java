package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PageController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        return "about-us";
    }

    @GetMapping("/questions")
    public String prepaQuest(@RequestParam Integer page, Model model) {
        if(page) { // sous-entendu page != null
            if(page.equals(1)) {
                return "choices";
            }
            if(page.equals(2)) {
                return "beforeQuest";
            }
            if(page.equals(3)) {
                return "information";
            }
            if(page.equals(4)) {
                return "intro";
            }
            // les pages 2, 3... seront à rajouter ici
            if(page.equals(100)) {
                return "result";
            }
            if(page.equals(101)) {
                return "resultQuest";
            }
        }
        return "prepaQuest"
    }
}