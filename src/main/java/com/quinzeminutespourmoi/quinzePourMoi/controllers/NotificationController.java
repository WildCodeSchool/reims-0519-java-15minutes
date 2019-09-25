package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/notifications")
    public String store(Authentication authentication, @ModelAttribute Hypnotherapist hypnotherapist, @RequestParam(required = false) Boolean userResponse, @RequestParam(required = false) Boolean hypnoResponse){
        User user = userRepository.findByMail(authentication.getName());
        notificationRepository.save(new Notification(user, hypnotherapist, true, true));
        return "redirect:/hypnotherapists/"+hypnotherapist.getId();
    }
}