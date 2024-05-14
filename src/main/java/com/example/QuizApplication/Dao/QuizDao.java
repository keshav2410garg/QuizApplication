package com.example.QuizApplication.Dao;

import com.example.QuizApplication.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizDao extends JpaRepository<Quiz,Integer> {


    Optional<Quiz> findAllById(Integer id);
}
