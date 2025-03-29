package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    //Create Quiz
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        System.out.println(quiz);
        return quizService.add(quiz);
    }

    //Get all Quizes
    @GetMapping
    public List<Quiz> getAllQuiz() {
        return quizService.get();
    }

    // Get Quiz by ID
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.get(id);
    }

    //update quiz
    @PutMapping
    public void updateQuiz(@RequestBody Quiz quiz) {
        quizService.update(quiz);
    }

}
