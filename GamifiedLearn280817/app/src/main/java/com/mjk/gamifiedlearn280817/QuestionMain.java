package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;



public class QuestionMain extends AppCompatActivity {


    private Button trueButton, falseButton, quitButton;
    private TextView scoreText, questionText, questionNoText;

    private Boolean correctAnswer;

    public Question currentQuestion = new Question();


    //private String badgeKey;
    public int score = 0;
    private int currentQuestionNo = 1;
    private int noOfQuestions; /*oldValue, newValue*/
    int quizType = 1;

    ArrayList<Question> questions = new ArrayList<>();
    ArrayList<Question> savedQuestions = new ArrayList<>();
    ArrayList<Badge> badges = new ArrayList<>();
    // private int num = 1;

    //SQLiteDatabase database;
    DatabaseAccess databaseAccess;


    //public SharedPreferences sharedPreferences;

    BadgeViewAdapter badgeViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);


        Intent getType = getIntent();
        quizType = getType.getIntExtra("quiz_type", 1);

        // create your questions there is no real reason to pass them via an intent
        questions = createQuestions(quizType);

        // set up ui elements
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        quitButton = (Button) findViewById(R.id.quit_button);
        questionText = (TextView) findViewById(R.id.quiz_textView);
        scoreText = (TextView) findViewById(R.id.score_textView);
        questionNoText = (TextView) findViewById(R.id.questionNo_textView);


        int index = currentQuestionNo - 1;
        currentQuestion = questions.get(index);

        // setup onclicklisteners

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    checkQuestion(true);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    checkQuestion(false);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
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
        //Question.setQuestionType(receivedType);

    }


    private void checkQuestion(Boolean usersAnswer) throws URISyntaxException {

        if (usersAnswer == correctAnswer) {
            score += 1;
            scoreText.setText("Score: " + score);
            //noCorrectAnswer++;
        }
        else {
            databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            ArrayList<Question> savedQuestionChecker = databaseAccess.receiveSavedQuestions();
            if (!savedQuestionChecker.contains(currentQuestion)) {savedQuestions.add(currentQuestion);}
            databaseAccess.close();
            Toast.makeText(this, "Question Incorrect! Saved.", Toast.LENGTH_LONG).show();
        }

        updateQuestion();
    }


    private void updateQuestion() throws URISyntaxException {

        if (currentQuestionNo >= noOfQuestions) {   // if the quiz is over

            Intent displayResults = new Intent(QuestionMain.this, ResultsScreen.class);
            displayResults.putExtra("final_score", score);      // adds score value to intent

            databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            badges = databaseAccess.getBadges();

            for ( int i = 0; i < badges.size(); i++ ) {
                badgeViewAdapter.updateBadgeRank(quizType, i, score);
            }
            databaseAccess.saveQuestions(savedQuestions);
            databaseAccess.close();

            startActivity(displayResults);                      // sends intent with score to ResultsScreen



            /*
            sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
            SharedPreferences.Editor updater = sharedPreferences.edit();

            oldValue = sharedPreferences.getInt(badgeKey, 0);
            newValue = oldValue + score;

            updater.putInt(badgeKey, newValue);
            updater.putInt("BadgeTotalProgress", newValue);

            updater.apply();

            finish();
            */


        } else {                            // moves to next question
            setQuestion(currentQuestionNo);
        }
    }

    private void setQuestion(int num) {
        currentQuestion = questions.get(num);
        questionText.setText(currentQuestion.question);
        correctAnswer = currentQuestion.correctAnswer;

        int number = num + 1;
        questionNoText.setText("Question Number: " + number); // update the question number displayed to match question

        currentQuestionNo = number;
    }

    private void resetTextViews() {
        questionNoText.setText("Question Number: " + currentQuestionNo);
        scoreText.setText("Score: " + score);
    }


    // creates an array of questions

    public ArrayList<Question> createQuestions(int questionType) {
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        questions = databaseAccess.getQuestions(questionType);
        databaseAccess.close();

        return questions;

    }
}

//   public int getScore(){return score;}
/*
    public void saveQuestions(){
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.saveQuestions(savedQuestions);
        databaseAccess.close();
    }
*/

/*
        switch(quizType){
            case 1: badgeKey = "Badge1Progress";
            case 2: badgeKey = "Badge2Progress";
            default: badgeKey = "Badge1Progress";
        }
        */
/*
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

        */


