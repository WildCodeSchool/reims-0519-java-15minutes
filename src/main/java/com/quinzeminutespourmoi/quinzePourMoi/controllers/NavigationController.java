package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Answer;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Notification;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.AnswerRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.NotificationRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

@Controller
class NavigationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    
    @GetMapping("/")
    public String intro(HttpSession session, Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            List <Notification> notifications = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notifications", notifications);
            
            // check if answers were stored before login
            Object answersAsObject = session.getAttribute("answers");

            if(answersAsObject != null) {
                Map<String, String> answers = (Map<String, String>)answersAsObject;

                for(Map.Entry<String, String> entry : answers.entrySet()) {
                    Long answerId = Long.valueOf(entry.getValue().substring(6));
                    Answer answer = answerRepository.getOne(answerId);
                    answer.getUsers().add(user);
                    answerRepository.save(answer);
                }                
                session.removeAttribute("answers");
            }
        }
        return "home";
    }

    @GetMapping("/home")
    public String preSurvey(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            List <Notification> notifications = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notifications", notifications);
        }
        return "preSurvey";
    }

    @GetMapping("/survey")
    public String choices(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            List <Notification> notifications = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notifications", notifications);
        }
        return "choices";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            List <Notification> notifications = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notifications", notifications);
        }
        return "about-us";
    }

    @GetMapping("/survey/result")
    public String resultSurvey(Model model, Authentication authentication) {
        if(authentication != null){
            User user = userRepository.findByMail(authentication.getName());
            model.addAttribute("user", user);
            List <Notification> notifications = notificationRepository.findNotificationByUserIdOrHypnotherapistId(user.getId(), user.getId());
            model.addAttribute("notifications", notifications);
        }
        return "resultSurvey";
    }

}
