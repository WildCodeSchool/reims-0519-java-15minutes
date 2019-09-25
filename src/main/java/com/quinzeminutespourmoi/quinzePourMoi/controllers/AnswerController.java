package com.quinzeminutespourmoi.quinzePourMoi.controllers;
import java.util.List;
import javax.validation.Valid;
import com.quinzeminutespourmoi.quinzePourMoi.entities.Answer;
import com.quinzeminutespourmoi.quinzePourMoi.repositories.AnswerRepository;

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
class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/answers")
    public String answers(Model model) {
        List<Answer> answers = answerRepository.findAll();
        model.addAttribute("answers", answers);
        return ""; /* Insert your template name here */
    }

    @GetMapping("/answers/{id}")
    public String read(Model model, @PathVariable("id") Long id) {
        Answer answer = answerRepository.findById(id).get();
        model.addAttribute("answer", answer);
        return ""; /* Insert your template name here */
    }

    @PostMapping("/answers")
    public String add(@Valid @ModelAttribute Answer answer) {
        Answer answer = answerRepository.save(new Answer());
        return "redirect:/answers/" + answer.getId();
    }

    @PutMapping("/answers/{id}")
    public Answer edit(@Valid @ModelAttribute Answer answer) {
        answerRepository.save(answer);
        return "";
    }

    @DeleteMapping("/answers/{id}")
    public void destroy(@PathVariable Long id) {
        answerRepository.delete(
            answerRepository.findById(id).get()
        ); 
    }
}