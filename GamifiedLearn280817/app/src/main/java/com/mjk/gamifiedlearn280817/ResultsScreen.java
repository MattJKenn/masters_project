package com.mjk.gamifiedlearn280817;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class ResultsScreen extends AppCompatActivity {


    Button endQuizButton;
    TextView finalScoreText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        endQuizButton = (Button)findViewById(R.id.end_button);
        finalScoreText = (TextView)findViewById(R.id.finalScore_textView);

        Intent result = getIntent();
        int score = result.getIntExtra("final_score", 0);
        int quizType = result.getIntExtra("quiz_type", 1);

        if(quizType != 3){finalScoreText.setText("Your Score is: " + score);}


        endQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {finish();}
        });
    }
}
