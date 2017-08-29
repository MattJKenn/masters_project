package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class QuestionMain extends AppCompatActivity {

    Button trueButton;
    Button falseButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        TextView textView = (TextView) findViewById(R.id.quiz_textView);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("test");
        Log.d("Quiz",message);

        if (message !=  null) {
            textView.setText(message);
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



}
