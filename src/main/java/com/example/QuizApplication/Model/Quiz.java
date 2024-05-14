package com.example.QuizApplication.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Title;

    @ManyToMany
    private List<Questions> questions;


   /*public void setTitle(String title) {
        this.title=title;
    }

    public void setQuestion(List<Questions> questions) {
    }*/
}
