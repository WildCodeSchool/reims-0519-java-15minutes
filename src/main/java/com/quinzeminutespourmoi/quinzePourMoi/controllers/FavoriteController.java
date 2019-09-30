package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Favorite;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class FavoriteController {

    @Autowired
    private FavoriteRepository favoriteRepository;

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