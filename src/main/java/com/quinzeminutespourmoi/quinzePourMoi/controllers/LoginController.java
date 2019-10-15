package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/loginError")
    public String loginError() {
        return "/loginError";
    }

/*     @Controller
    public class DefaultController {
        @RequestMapping("/default")
        public String defaultAfterLogin(HttpServletRequest request,
                @RequestParam(defaultValue = "false") boolean isHypnotherapist) {
            if (isHypnotherapist) {
                return "redirect:/users/profile";
            }
            return "redirect:/home";

        }
    } */
}