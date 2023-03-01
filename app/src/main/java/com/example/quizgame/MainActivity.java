package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
    }

    private void linkViews() {
        Button startGameButton = findViewById(R.id.start_game_button);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });
    }

    private void startQuiz()  {
        setupGame();
        // Create intent to transition to QuizActivity screen
        Intent quizActivityIntent = new Intent(this, QuizActivity.class);
        startActivity(quizActivityIntent);
    }

    private void setupGame() {
        QuestionInfo question1 = new QuestionInfo("1 + 1 = ?",
                "Grade 1 Math",
                "2");
        QuestionInfo question2 = new QuestionInfo("What is the capital of Canada?",
                "Grade 3 Geography",
                "Ottawa",
                "Toronto",
                "Ottawa",
                "Yukon",
                "Vancouver");
        QuestionInfo question3 = new QuestionInfo("Which is the fastest bird on foot?",
                "Grade 5 Science",
                "Ostrich",
                R.drawable.birds);
        CurrentGame.get().currentQuestions.add(question1);
        CurrentGame.get().currentQuestions.add(question2);
        CurrentGame.get().currentQuestions.add(question3);
        CurrentGame currentGame = CurrentGame.get();
        currentGame.currentState = GameState.IN_PROGRESS;
        currentGame.currentQuestionInd += 1;
    }
}