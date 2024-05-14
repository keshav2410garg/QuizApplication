package com.example.QuizApplication.Dao;


import com.example.QuizApplication.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);

    @Query(value="SELECT * FROM Questions q where q.category=:category ORDER BY RANDOM() LIMIT :numq",nativeQuery = true)
    List<Questions> FindQuestionsByCategory(String category,int numq);
}
