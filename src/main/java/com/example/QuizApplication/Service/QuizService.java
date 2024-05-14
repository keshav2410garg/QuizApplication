package com.example.QuizApplication.Service;


import com.example.QuizApplication.Dao.QuestionDao;
import com.example.QuizApplication.Dao.QuizDao;
import com.example.QuizApplication.Model.QuestionWrapper;
import com.example.QuizApplication.Model.Questions;
import com.example.QuizApplication.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuestionDao questiondao;

    public ResponseEntity<String> createQuiz(String category, int numq, String title) {

        List<Questions> questions= questiondao.FindQuestionsByCategory(category,numq);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);


        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> GetQuizQuestions(Integer id) {
        Optional<Quiz> quiz;
        quiz = quizdao.findAllById(id);
        List<Questions> QuestionsfromDB=quiz.get().getQuestions();
    }
}
