package com.example.quizgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MultiChoiceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multi_choice, container, false);
        linkViews(view);
        return view;
    }

    /* Defines how UI components are shown and what happens when player interacts with them. */
    private void linkViews(View view) {
        /* Part 2: Display the current question and the possible choices the player can choose from. */
        QuestionInfo currentQuestion = CurrentGame.getCurrentQuestion();
        String currentQuestionString = currentQuestion.question;
        String choice1 = currentQuestion.choices.get(0);
        String choice2 = currentQuestion.choices.get(1);
        String choice3 = currentQuestion.choices.get(2);
        String choice4 = currentQuestion.choices.get(3);

        TextView multiChoiceQuestion = view.findViewById(R.id.multi_choice_question);
        multiChoiceQuestion.setText(currentQuestionString);
        Button choice1Button = view.findViewById(R.id.choice_1);
        choice1Button.setText(choice1);
        Button choice2Button = view.findViewById(R.id.choice_2);
        choice2Button.setText(choice2);
        Button choice3Button = view.findViewById(R.id.choice_3);
        choice3Button.setText(choice3);
        Button choice4Button = view.findViewById(R.id.choice_4);
        choice4Button.setText(choice4);




    }

}