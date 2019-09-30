package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/notifications")
    public String store(Authentication authentication, Notification notification){
        notification.setUser((User)authentication.getPrincipal());
        notification = notificationRepository.save(notification);
        return "redirect:/hypnotherapists/"+notification.getHypnotherapist().getId();
    }

    @PatchMapping("/notifications/{id}")
    public String update(Authentication authentication, @PathVariable Long id, Notification notification){
        Notification notificationToPatch = notificationRepository.findById(id).get();
        if(notification.getUserResponse() != null) {
            notificationToPatch.setUserResponse(
                notification.getUserResponse()
            );
        }
        if(notification.getHypnotherapistResponse() != null) {
            notificationToPatch.setHypnotherapistResponse(
                notification.getHypnotherapistResponse()
            );
        }
        notificationRepository.save(notificationToPatch);
        return "redirect:/users/profile";
    }


}