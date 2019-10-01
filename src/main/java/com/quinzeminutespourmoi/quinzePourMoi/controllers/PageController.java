package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

@Controller
class PageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    
    @GetMapping("/")
    public String intro(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        return "home";
    }

    @GetMapping("/home")
    public String preSurvey(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        return "preSurvey";
    }

    @GetMapping("/survey")
    public String choices(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        return "choices";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        return "about-us";
    }

    @GetMapping("/survey/result")
    public String resultSurvey(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        return "resultSurvey";
    }

    @GetMapping("/comment")
    public String comment(Model model){
        return "comment";
    }

}
