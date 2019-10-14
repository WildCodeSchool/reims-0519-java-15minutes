package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController{

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    @GetMapping("/loginError")
    public String loginError() {
        return "/loginError";
    }
    @Controller
    public class DefaultController {
        @RequestMapping("/default")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("Hypnotherapist")) {
                return "redirect:/users/profil";
            }
            return "redirect:/home/";
        }
    }
}