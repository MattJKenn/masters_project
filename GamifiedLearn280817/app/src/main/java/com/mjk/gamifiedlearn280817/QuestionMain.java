package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class QuestionMain extends AppCompatActivity {

    Button trueButton;
    Button falseButton;
    Button quitButton;

    ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        createQuestions();
        TextView textView = (TextView) findViewById(R.id.quiz_textView);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("test");
        Log.d("Quiz",message);

        if (message !=  null) {
            textView.setText(message);
        }

        if (questions.size() > 0) {
//            for (Question question : questions) {
//                Log.d("questions",question.question);
//            }
            textView.setText( questions.get(0).question);
        }
    }


    public void onClick (View v) {
        finish();
        }


    // catch string

    // load file

    // create objects

    // question counter

    // score counter

    // thread.sleep()

    // close when last question is answered

    // final completion screen

    private void createQuestions() {
        questions = new ArrayList<>();
        Question q1 = new Question("This is easier than i thought", true);
        Question q2 = new Question("The sky is green",false);

        questions.add(q1);
        questions.add(q2);
    }

}
