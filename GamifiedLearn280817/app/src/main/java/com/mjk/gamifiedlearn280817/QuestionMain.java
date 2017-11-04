package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import com.mjk.gamifiedlearn280817.questiondb.QuestionDB;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

public class QuestionMain extends AppCompatActivity {


    private Button trueButton, falseButton, quitButton;
    private TextView scoreText, questionText, questionNoText;

    private String currentQuestionText;
    private Boolean correctAnswer;

    public QuestionDB Question;
    public List<QuestionDB> QuestionList;
    public List<QuestionDB> FetchedQuestions;


    private int score = 0;
    private int currentQuestionNo = 1;
    private int noOfQuestions;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        // create your questions there is no real reason to pass them via an intent
       // Questions = new QuestionDB();
       // questionsArrayList = new ArrayList<>();

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
        scoreText.setText("Score: " + score);
        QuestionLogic(currentQuestionNo);

        SugarContext.init(this);

        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        schemaGenerator.createDatabase(new SugarDb(this).getDB());

        Question.createQuestions();

        QuestionList = Question.listAll(QuestionDB.class);
        noOfQuestions = QuestionList.size();
    }

    private void checkQuestion(boolean usersAnswer) {
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
            startActivity(displayResults);                      // sends intent with score to ResultsScreen
            finish();
        }
        else {
            QuestionLogic(currentQuestionNo);
        }
    }

  /*  private void setQuestion(int num) {

    }
    */
    private void resetTextViews(){
        questionText.setText("");
        //currentQuestionNo = 1;
        questionNoText.setText("Question Number: " + currentQuestionNo);
    }

    private void QuestionLogic(int num){
        QuestionDB selectedQuestion = QuestionList.get(num);
        questionText.setText(selectedQuestion.QuestionText);

        currentQuestionText = Question.getQuestionText();
        questionText.setText(currentQuestionText);

        correctAnswer = Question.getCorrectAnswer();
        Question.setCorrectAnswer(correctAnswer);

        num += 1;
        questionNoText.setText("Question Number: " + num); // update the question number displayed to match question

    }
}


