package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Answer;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Question;
import com.quinzeminutespourmoi.quinzePourMoi.entities.User;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.AnswerRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.QuestionRepository;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class SurveyController{
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/survey/smoke")
    public String smokesurvey(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(70L, 79L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/addiction")
    public String addictsurvey(Model model){
        return "addictSurvey";
    }

    @GetMapping("/survey/addiction/food")
    public String foodAddictionSurvey(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(80L, 89L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/addiction/screen")
    public String screenAddictionSurvey(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(100L, 110L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/addiction/alcohol")
    public String alcoholAddictionSurvey(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(90L, 99L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/animals+insects")
    public String animalsFear(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(10L, 19L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/car")
    public String carFear(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(20L, 29L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/plane")
    public String planeFear(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(30L, 39L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/people")
    public String peopleFear(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(40L, 49L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/water")
    public String waterFear(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(50L, 59L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear/close")
    public String closeFear(Model model){
        Set<Question> questions = questionRepository.findByIdBetween(60L, 69L);
        model.addAttribute("questions", questions);
        return "alcoholAddictionSurvey";
    }

    @GetMapping("/survey/fear")
    public String fearSurvey(Model model){
        return "fearSurvey";
    }

    @PostMapping("/survey")
    public String store(HttpSession session, Authentication authentication, @RequestParam Map<String, String> request) {
        if(authentication == null) {
            session.setAttribute("answers", request);
        }
        else {
            User user = (User)authentication.getPrincipal();

            for(Map.Entry<String, String> entry : request.entrySet()) {
                Long answerId = Long.valueOf(entry.getValue().substring(6));
                Answer answer = answerRepository.getOne(answerId);
                answer.getUsers().add(user);
                answerRepository.save(answer);
            }
        }
        return "redirect:/survey/result";
    }
}