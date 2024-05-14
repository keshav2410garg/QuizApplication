package com.example.QuizApplication.Service;

import com.example.QuizApplication.Dao.QuestionDao;
import com.example.QuizApplication.Model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;


    public String AddQuestion(Questions question) {
        questiondao.save(question);
        return "Success";
    }


    /*public ResponseEntity<List<Questions>> GetAllQuestions(){
        try{
            return new ResponseEntity<List<Questions>>(questiondao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }*/
    public List<Questions> GetAllQuestions(){
        return questiondao.findAll();
    }

    public List<Questions> GetQuestionsByCategory(String category){
       return questiondao.findByCategory(category);
    }

}
