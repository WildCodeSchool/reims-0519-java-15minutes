package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

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
    public String profile(Authentication authentication, Hypnotherapist hypnotherapist, double lat, double lng, String address) {
        Hypnotherapist hypnotherapistToPatch = hypnotherapistRepository.findByMail(authentication.getName());
        hypnotherapistToPatch.setDescription(hypnotherapist.getDescription());
        hypnotherapistToPatch.setPhone(hypnotherapist.getPhone());
        hypnotherapistToPatch.setAddress(hypnotherapist.getAddress());
        hypnotherapistToPatch.setAdr_postal(hypnotherapist.getAdr_postal());
        hypnotherapistToPatch.setTown(hypnotherapist.getTown());
        hypnotherapistToPatch.setLng(hypnotherapist.getLng());
        hypnotherapistToPatch.setLat(hypnotherapist.getLat());

        HttpResponse<JsonNode> jsonResponse;
        try {
            jsonResponse = Unirest.get("https://api.opencagedata.com/geocode/v1/json?").queryString("q", address)
                    .queryString("key", "6deb4479ec784e1d9a5a521e2da8655c").asJson();

            JSONObject rootGeo = (JSONObject) jsonResponse.getBody().getObject();
            JSONObject firstResult = (JSONObject) rootGeo.getJSONArray("results").get(0);
            JSONObject geometry = (JSONObject) firstResult.getJSONObject("geometry");
            lng = geometry.getDouble("lng");
            lat = geometry.getDouble("lat");

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        User user = userRepository.findByMail(authentication.getName());
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
    public String hypnotherapistById (Model model, Authentication authentication, @PathVariable("id") Long hypnotherapistId) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            Notification notification = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notification", notification);
        }
        Hypnotherapist hypnotherapist = hypnotherapistRepository.findById(hypnotherapistId).get();
        User user = (User)authentication.getPrincipal();
        Notification notification = notificationRepository.findNotificationByUserIdAndHypnotherapistId(user.getId(), hypnotherapistId);
        model.addAttribute("notification", notification);
        model.addAttribute("hypnotherapist", hypnotherapist);
        return "infos";
    }
}