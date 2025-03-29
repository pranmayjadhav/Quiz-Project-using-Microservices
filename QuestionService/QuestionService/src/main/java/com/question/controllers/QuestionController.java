package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    //create
    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.create(question);
    }
    //get all
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.get();
    }
    //get all by id
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getOne(id);
    }
    //get all by quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
        return questionService.getQuestionsByQuizId(quizId);
    }
}
