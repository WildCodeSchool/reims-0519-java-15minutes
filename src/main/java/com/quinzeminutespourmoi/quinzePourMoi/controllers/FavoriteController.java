package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import java.util.List;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Favorite;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.FavoriteRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class FavoriteController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/favorites")
    public String favorites(Model model, Authentication authentication, Long hypnotherapistId) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        User user = (User)authentication.getPrincipal();
        List <Favorite> favorites = favoriteRepository.findFavoriteByUserIdOrHypnotherapistId(user.getId(),user.getId());
        model.addAttribute("favorites", favorites);
        return "favorites";
    }

    @PostMapping("/favorites")
    public String store(Authentication authentication, Favorite favorite){
        favorite.setUser((User)authentication.getPrincipal());
        favorite = favoriteRepository.save(favorite);
        return "redirect:/hypnotherapists/"+favorite.getHypnotherapist().getId();
    }

    @PostMapping("/favorites/{id}")
    public String destroy(@PathVariable Long id, Favorite favorite) {
        favoriteRepository.delete(
            favoriteRepository.findById(id).get());
        return "redirect:/hypnotherapists/"+favorite.getHypnotherapist().getId();
    }
}