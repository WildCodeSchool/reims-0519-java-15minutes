package com.quinzeminutespourmoi.quinzePourMoi.controllers;

import java.util.List;

import javax.validation.Valid;

import com.quinzeminutespourmoi.quinzePourMoi.entities.Question;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.QuestionRepository;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public String questions(Model model) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        return ""; /* Insert your template name here */
    }

    @GetMapping("/questions/{id}")
    public String read(Model model, @PathVariable("id") Long id) {
        Question question = questionRepository.findById(id).get();
        model.addAttribute("question", question);
        return ""; /* Insert your template name here */
    }

    @PostMapping("/questions")
    public String add(@Valid @ModelAttribute Question question) {
        Question question = questionRepository.save(new Question());
        return "redirect:/questions/" + question.getId();
    }

    @PutMapping("/questions/{id}")
    public Question edit(@Valid @ModelAttribute Question question) {
        questionRepository.save(question);
        return "/";
    }

    @DeleteMapping("/questions/{id}")
    public void destroy(@PathVariable Long id) {
        questionRepository.delete(
            questionRepository.findById(id).get()
        ); 
    }
}