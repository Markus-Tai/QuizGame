package com.example.quizgame;

import java.util.ArrayList;

public class CurrentGame {

    ArrayList<QuestionInfo> currentQuestions = new ArrayList<>();
    int currentQuestionInd = -1;
    String currentAnswer = "";
    GameState currentState = null;

    private static CurrentGame instance = null;
    public static CurrentGame get() {
        if (instance == null) {
            instance = new CurrentGame();
        }
        return instance;
    }

    public static QuestionInfo getCurrentQuestion() {
        if (instance != null) {
            return instance.currentQuestions.get(instance.currentQuestionInd);
        }
        return null;
    }
}
