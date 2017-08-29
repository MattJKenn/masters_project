package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class QuestionMain extends AppCompatActivity {

    Button trueButton;
    Button falseButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);
    }


    public void onClick (View v) {
        Intent quitQuiz =  new Intent(this, AppMain.class);
        startActivity(quitQuiz);
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
