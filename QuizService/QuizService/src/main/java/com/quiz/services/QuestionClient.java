package com.quiz.services;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//using fiegn client url
//@FeignClient(url = "http://localhost:8082", value = "Question-Client")

//using Load Balancer using application name
@FeignClient(name = "QUESTIONSERVICE")

public interface QuestionClient {
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
