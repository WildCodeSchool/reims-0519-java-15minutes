package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Favorite;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.FavoriteRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    FavoriteRepository favoriteRepository;

    @GetMapping("/subscribe")
    public String subscribe(Model model) {
        model.addAttribute("user", new User());
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public String store(HttpServletRequest request, String mail, String password, User user,
            @RequestParam(defaultValue = "false") boolean isHypnotherapist) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (isHypnotherapist) {
            user = hypnotherapistRepository.save(new Hypnotherapist(user));
        }
        else {
            user = userRepository.save(user);
        }

        try {
            request.login(mail, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        if (isHypnotherapist) {
            return "redirect:/hypnotherapists/profile";
        }
        return "redirect:/users/profile";
    }

    @GetMapping("/users/profile")
    public String read(Model model, Authentication authentication, Long hypnotherapistId) {
        User user = userRepository.findByMail(authentication.getName());
        model.addAttribute("user", user);
        Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
        model.addAttribute("notification", notification);
        List <Favorite> favorites = favoriteRepository.findFavoriteByUserIdOrHypnotherapistId(user.getId(),user.getId());
        model.addAttribute("favorites", favorites);
        return "profilePerso";
    }

    @GetMapping("/users/{id}")
    public String read(Model model, @PathVariable("id") Long userId, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        User user = userRepository.findById(userId).get();
        model.addAttribute("user", user);
        return "profileUser";
    }
}