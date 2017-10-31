package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import com.mjk.gamifiedlearn280817.questiondb.QuestionDB;

public class QuestionMain extends AppCompatActivity {



    private Button trueButton, falseButton, quitButton;
    private TextView scoreText, questionText, questionNoText;

    private Boolean correctAnswer;
    private QuestionDB currentQuestion;

    private int score = 0;
    private int currentQuestionNo = 0;

    public List<QuestionDB> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        // create your questions there is no real reason to pass them via an intent
        createQuestions();

        // set up ui elements
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        quitButton = (Button) findViewById(R.id.quit_button);
        questionText = (TextView) findViewById(R.id.quiz_textView);
        scoreText = (TextView) findViewById(R.id.score_textView);
        questionNoText = (TextView) findViewById(R.id.questionNo_textView);

        // setup onclicklisteners
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQuestion(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQuestion(false);
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        // setup question
        scoreText.setText("Score: " + score);
        setQuestion(0);
    }

    private void checkQuestion(boolean usersAnswer) {
        if (usersAnswer == correctAnswer) {
            score += 1;
            scoreText.setText("Score: " + score);
        }
        updateQuestion();
    }

    private void updateQuestion() {
        currentQuestionNo += 1;
        if (currentQuestionNo >= questions.size()) {                   // if the quiz is over
            Intent displayResults = new Intent(QuestionMain.this, ResultsScreen.class);
            displayResults.putExtra("final_score", score);      // adds score value to intent
            startActivity(displayResults);                      // sends intent with score to ResultsScreen
            finish();
        } else {
            setQuestion(currentQuestionNo);
        }
    }

    private void setQuestion(int num) {
        currentQuestion = questions.get(currentQuestionNo);
        questionText.setText(currentQuestion.getQuestionText());
        correctAnswer = currentQuestion.getCorrectAnswer();

        int number = num + 1;
        questionNoText.setText("Question Number: " + number); // update the question number displayed to match question

    }

    // creates an array of questions. This function could be used to load questions from a database
    public void createQuestions() {

        Intent getQuizType = getIntent();
        int quizType = getQuizType.getIntExtra("quiz_type", 1);
        
        QuestionDB q1 = new QuestionDB("This is easier than i thought", true);
        q1.save();
        QuestionDB q2 = new QuestionDB("The sky is green", false);
        q2.save();
        QuestionDB q3 = new QuestionDB("Earth is 70% land", false);
        q3.save();
        QuestionDB q4 = new QuestionDB("An elephant is smaller than the moon", true);
        q4.save();
        QuestionDB q5 = new QuestionDB("There are 2 hydrogen atoms in a water molecule", true);
        q5.save();

    }
}
