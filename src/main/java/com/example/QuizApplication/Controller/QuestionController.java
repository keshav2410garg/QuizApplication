package com.example.QuizApplication.Controller;


import com.example.QuizApplication.Model.Questions;
import com.example.QuizApplication.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Question")
public class QuestionController {

    @Autowired
    QuestionService questionservice;

    @GetMapping(path="questions")
    public List<Questions> GetAllQuestions(){
        List<Questions> l= (List<Questions>) questionservice.GetAllQuestions();
        for(Questions q:l){
            System.out.println(q);
        }
        return (List<Questions>) questionservice.GetAllQuestions();
    }

    @GetMapping(path="Category/{category}")
    public List<Questions> GetQuestionsBYcATEGORY(@PathVariable("category") String category){
        return questionservice.GetQuestionsByCategory(category);
    }

    @PostMapping(path="add")
    public String AddQuestion(@RequestBody Questions question){
        return questionservice.AddQuestion(question);
    }

}
