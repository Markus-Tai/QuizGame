package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        int nextQuestionInd = CurrentGame.get().currentQuestionInd;
        showNextQuestion(nextQuestionInd);

        linkViews();
    }

    private void linkViews() {
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleResult(true);
            }
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void handleResult(Boolean isCorrect) {
        CurrentGame currentGame = CurrentGame.get();
        if (isCorrect) {
            currentGame.currentQuestionInd += 1;
            if (currentGame.currentQuestionInd == currentGame.currentQuestions.size()) {
                currentGame.currentState = GameState.WIN;
                endQuiz();
            } else {
                currentGame.currentAnswer = "";
                showNextQuestion(currentGame.currentQuestionInd);
            }
        } else {
            currentGame.currentState = GameState.LOSE;
            endQuiz();
        }
    }

    private void showNextQuestion(int nextQuestionInd) {
        QuestionInfo nextQuestion = CurrentGame.get().currentQuestions.get(nextQuestionInd);
        TextView questionTitle = findViewById(R.id.question_title);
        questionTitle.setText(String.format("Question %d: %s", nextQuestionInd+1, nextQuestion.category));

        if (nextQuestion.choices != null) {
            showFragment(new MultiChoiceFragment());
        } else if (nextQuestion.img != 0) {
            showFragment(new ImageQNAFragment());
        } else {
            showFragment(new QNAFragment());
        }
    }

    private void endQuiz()  {
        // Create intent to transition to ResultActivity screen
        Intent resultActivityIntent = new Intent(this, ResultActivity.class);
        startActivity(resultActivityIntent);
    }
}