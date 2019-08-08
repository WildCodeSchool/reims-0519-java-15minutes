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

    @GetMapping("/prepaQuest")
    public String prepaQuest(Model model) {
        return "prepaQuest";
    }

    @GetMapping("/pageAnnonce")
    public String pageAnnonce(Model model) {
        return "pageAnnonce";
    }

    @GetMapping("/pageVideo")
    public String pageVideo(Model model) {
        return "pageVideo";
    }

    @GetMapping("/resultQuest")
    public String resultQuest(Model model) {
        return "resultQuest";
    }

}