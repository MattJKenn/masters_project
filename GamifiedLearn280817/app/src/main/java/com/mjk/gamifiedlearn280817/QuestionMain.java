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

    Button trueButton = (Button)findViewById(R.id.true_button);
    Button falseButton = (Button)findViewById(R.id.false_button);

    //ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        //createQuestions();
        TextView textView = (TextView) findViewById(R.id.quiz_textView);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("test");
        Log.d("Quiz", message);

        if (message != null) {
            textView.setText(message);
        }

        /*if (questions.size() > 0) {
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

   /* private void createQuestions() {
        questions = new ArrayList<>();
        Question q1 = new Question("This is easier than i thought", true);
        Question q2 = new Question("The sky is green",false);
        Question q3 = new Question("Earth is 70% land", false);
        Question q4 = new Question("An elephant is smaller than the moon", true);
        Question q5 = new Question("There are 2 hydrogen atoms in a water molecule", true);
        questions.add(q1);
        questions.add(q2);
    }
    */
    }}