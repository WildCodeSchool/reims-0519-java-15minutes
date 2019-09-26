package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Hypnotherapist;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.quinzeminutespourmoi.quinzePourMoi.repositories.HypnotherapistRepository;
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

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class HypnotherapistController {

    @Autowired
    private HypnotherapistRepository hypnotherapistRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/infos")
    public String infos(Model model) {
        return "infos";
    }

    @PostMapping("/hypnoRegister")
    public String register(Authentication authentication, @RequestParam String description, @RequestParam String phone,
            @RequestParam String address, @RequestParam String adr_postal, @RequestParam String town, @RequestParam Double lat, @RequestParam Double lng) {

        HttpResponse<JsonNode> jsonResponse;
        try {
            jsonResponse = Unirest.get("https://api.opencagedata.com/geocode/v1/json?").queryString("q", address)
                    .queryString("key", "6deb4479ec784e1d9a5a521e2da8655c").asJson();

            assertNotNull(jsonResponse.getBody());
            assertEquals(200, jsonResponse.getStatus());

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
        hypnotherapistRepository
                .save(new Hypnotherapist(user, description, phone, address, adr_postal, town, lat, lng));
        return "home";
    }

    private void assertNotNull(JsonNode jsonNode) {
    }

    private void assertEquals(int i, int status) {
    }

    @GetMapping("/hypnoRegister")
    public String subscribe(Model model) {
        model.addAttribute("hypnotherapist", new Hypnotherapist());
        return "hypnoRegister";
    }

    @GetMapping("/hypnotherapists")
    public String hypnotherapists(Model model) {
        List<Hypnotherapist> hypnotherapists = hypnotherapistRepository.findAll();
        model.addAttribute("hypnotherapists", hypnotherapists);
        return "hypnotherapists";
    }

    @GetMapping("/hypnotherapists/{id}")
    public String HypnotherapistById(Model model, @PathVariable("id") Long hypnotherapistId) {
        Hypnotherapist hypnotherapist = hypnotherapistRepository.findById(hypnotherapistId).get();
        model.addAttribute("hypnotherapist", hypnotherapist);
        return "infos";
    }

}