package com.example.QuizApplication.Controller;


import com.example.QuizApplication.Model.QuestionWrapper;
import com.example.QuizApplication.Model.Questions;
import com.example.QuizApplication.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="Quiz")
public class QuizController {

    @Autowired
    QuizService quizservice;



    @PostMapping(path="create")
    public ResponseEntity<String>  createQuiz(@RequestParam String category,@RequestParam int numq,@RequestParam String title){
        return quizservice.createQuiz(category,numq,title);

    }

    @GetMapping(path="get/{id")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizservice.GetQuizQuestions(id);
    }



}
