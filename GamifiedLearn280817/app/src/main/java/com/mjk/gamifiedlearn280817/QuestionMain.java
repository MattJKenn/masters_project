package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class QuestionMain extends AppCompatActivity {


    // you should declare your global variables at the top of the class
    Button trueButton;
    Button falseButton;
    TextView textView;

    boolean optionSelected;

    //ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        // create buttons inside the onCreate, you cannot call findViewById from outside of this method.
        trueButton = (Button)findViewById(R.id.true_button);
        falseButton = (Button)findViewById(R.id.false_button);

        //createQuestions();
        textView = (TextView) findViewById(R.id.quiz_textView);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("test");
        Log.d("Quiz", message);

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);

        if (message != null) {
            textView.setText(message);
        }

       trueButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               optionSelected = true;
               textView.setText("Well done you are right");
               finish();          }
       });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionSelected = false;
                textView.setText("You are wrong sorry");
                finish();
            }
        });

    }

    }



        /*if (questions.size() > 0) {
           for (Question question : questions) {
              Log.d("questions",question.question);
         }
            textView.setText( questions.get(0).question);
        }
        
    }



    // catch string

    // load file

    // create objects

    // question counter

    // score counter

    // thread.sleep()

    // close when last question is answered

    // final completion screen

    }
*/
