package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Favorite;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.repositories.FavoriteRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class HypnotherapistController {

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/infos")
    public String infos(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        return "infos";
    }

    @PatchMapping("/hypnotherapists/profile")
    public String register(Authentication authentication, Hypnotherapist hypnotherapist) {
        Hypnotherapist hypnotherapistToPatch = hypnotherapistRepository.findByMail(authentication.getName());
        hypnotherapistToPatch.setDescription(hypnotherapist.getDescription());
        hypnotherapistToPatch.setPhone(hypnotherapist.getPhone());
        hypnotherapistToPatch.setAddress(hypnotherapist.getAddress());
        hypnotherapistToPatch.setAdr_postal(hypnotherapist.getAdr_postal());
        hypnotherapistToPatch.setTown(hypnotherapist.getTown());
        hypnotherapistRepository.save(hypnotherapistToPatch);
        return "home";
    }

    @GetMapping("/hypnotherapists/profile")
    public String subscribe(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        model.addAttribute("hypnotherapist", hypnotherapistRepository.findByMail(authentication.getName()));
        return "hypnoRegister";
    }

    @GetMapping("/hypnotherapists")
    public String hypnotherapists(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        List<Hypnotherapist> hypnotherapists = hypnotherapistRepository.findAll();
        model.addAttribute("hypnotherapists", hypnotherapists);
        return "hypnotherapists";
    }

    @GetMapping("/hypnotherapists/{id}")
    public String HypnotherapistById (Model model, Authentication authentication, @PathVariable("id") Long hypnotherapistId) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        Hypnotherapist hypnotherapist = hypnotherapistRepository.findById(hypnotherapistId).get();
        User user = (User)authentication.getPrincipal();
        Notification notification = notificationRepository.findNotificationByUserIdAndHypnotherapistId(user.getId(), hypnotherapistId);
        Favorite favorite = favoriteRepository.findFavoriteByUserIdAndHypnotherapistId(user.getId(), hypnotherapistId);
        model.addAttribute("notification", notification);
        model.addAttribute("hypnotherapist", hypnotherapist);
        model.addAttribute("favorite", favorite);
        return "infos";
    }
}