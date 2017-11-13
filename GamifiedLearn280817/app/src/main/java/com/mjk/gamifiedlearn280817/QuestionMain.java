package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class QuestionMain extends AppCompatActivity {


    private Button trueButton, falseButton, quitButton;
    private TextView scoreText, questionText, questionNoText;


    private Boolean correctAnswer;

    public Question objectQuestion;

    private String currentQuestionText;

    private int score = 0;
    private int currentQuestionNo = 1;
    private int noOfQuestions;

    ArrayList<Question> questions;
    // private int num = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);


        Intent getType = getIntent();
        int quizType = getType.getIntExtra("quiz_type", 1);

        // create your questions there is no real reason to pass them via an intent

        objectQuestion = new Question();
        questions = createQuestions(quizType);


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

        resetTextViews();


        // setup question


        noOfQuestions = questions.size();

        setQuestion(0);

    }


    private void checkQuestion(Boolean usersAnswer) {
        if (usersAnswer == correctAnswer) {
            score += 1;
            scoreText.setText("Score: " + score);
        }

        updateQuestion();
    }

    private void updateQuestion() {

        if (currentQuestionNo >= noOfQuestions) {                   // if the quiz is over
            Intent displayResults = new Intent(QuestionMain.this, ResultsScreen.class);
            displayResults.putExtra("final_score", score);      // adds score value to intent
            //displayResults.putParcelableArrayListExtra("question_list", questions);
            startActivity(displayResults);                      // sends intent with score to ResultsScreen
            finish();
        } else {
            setQuestion(currentQuestionNo);
        }
    }

    private void setQuestion(int num) {

        objectQuestion = questions.get(num);
        questionText.setText(currentQuestionText);
        correctAnswer = objectQuestion.correctAnswer;


        num += 1;
        questionNoText.setText("Question Number: " + num); // update the question number displayed to match question
    }

    private void resetTextViews() {
        questionNoText.setText("Question Number: " + currentQuestionNo);
        scoreText.setText("Score: " + score);
    }


    // creates an array of questions. This function could be used to load questions from a database


    public static ArrayList<Question> createQuestions(int questionType) {
        ArrayList<Question> questions = new ArrayList<>();

        switch (questionType) {
            case (1):
                Question q1 = new Question("This is easier than i thought", true);
                questions.add(q1);
                Question q2 = new Question("The sky is green", false);
                questions.add(q2);
                Question q3 = new Question("Earth is 70% land", false);
                questions.add(q3);
                Question q4 = new Question("An elephant is smaller than the moon", true);
                questions.add(q4);
                Question q5 = new Question("There are 2 hydrogen atoms in a water molecule", true);
                questions.add(q5);
                return questions;

            case (2):
                Question q6 = new Question("This is a second quiz", true);
                questions.add(q6);
                Question q7 = new Question("Spiders have 2 eyes", false);
                questions.add(q7);
                Question q8 = new Question("This is an achievement", true);
                questions.add(q8);
                Question q9 = new Question("Java is not a type of teapot", true);
                questions.add(q9);
                Question q10 = new Question("No human has eyes", false);
                questions.add(q10);
                return questions;
            }
        return questions;
    }
}


