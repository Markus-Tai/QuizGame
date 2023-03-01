package com.example.quizgame;

import java.util.ArrayList;

public class QuestionInfo {

    public String question;
    public String category;
    public String answer;
    public ArrayList<String> choices = null;
    public int img = 0;

    public QuestionInfo(String question, String category, String answer) {
        //this is the qna type
        this.question = question;
        this.category = category;
        this.answer = answer;
    }

    public QuestionInfo(String question, String category, String answer,
                        String choice1, String choice2, String choice3,
                        String choice4) {
        //this is the multi choice type
        this.question = question;
        this.category = category;
        this.answer = answer;
        this.choices = new ArrayList<>();
        this.choices.add(choice1);
        this.choices.add(choice2);
        this.choices.add(choice3);
        this.choices.add(choice4);
    }

    public QuestionInfo(String question, String category, String answer, int img) {
        //this is the img qna type
        this.question = question;
        this.category = category;
        this.answer = answer;
        this.img = img;
    }

}
