package com.example.QuizApplication.Controller;


import com.example.QuizApplication.Model.QuestionWrapper;
import com.example.QuizApplication.Model.Questions;
import com.example.QuizApplication.Model.Response;
import com.example.QuizApplication.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="quiz")
public class QuizController {

    @Autowired
    QuizService quizservice;


    //http://localhost:8080/quiz/create?category=JAVA&numq=4&title=JAVAQuiz
    @PostMapping(path="create")
    public ResponseEntity<String>  createQuiz(@RequestParam String category,@RequestParam int numq,@RequestParam String title){

        return quizservice.createQuiz(category,numq,title);
    }

    @GetMapping(path="get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizservice.GetQuizQuestions(id);
    }

    @PostMapping(path="submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@RequestParam Integer id,@RequestBody List<Response> responses){
        return quizservice.CalculateResult(id,responses);
    }



}
