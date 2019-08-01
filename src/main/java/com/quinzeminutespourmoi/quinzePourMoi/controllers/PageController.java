package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}