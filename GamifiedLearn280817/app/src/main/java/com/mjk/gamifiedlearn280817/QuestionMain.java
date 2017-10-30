package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import com.mjk.gamifiedlearn280817.questiondb.QuestionDB;
import com.orm.SugarContext;

public class QuestionMain extends AppCompatActivity {



    private Button trueButton, falseButton, quitButton;
    private TextView scoreText, questionText, questionNoText;

    private boolean correctAnswer;
    private int score = 0;
    private int currentQuestionNo = 1;

    public List<QuestionDB> questions = new ArrayList<>();
    public int currentQuestion;
    //int currentQuestion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        // load questions into database
        createQuestions();

        // get questions from database
        questions = QuestionDB.listAll(QuestionDB.class);

        SugarContext.init(this);

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
            displayResults.putParcelableArrayListExtra("question_list", questions);
            startActivity(displayResults);                      // sends intent with score to ResultsScreen
            finish();
        } else {
            setQuestion(currentQuestionNo);
        }
    }

    private void setQuestion(int num) {
        currentQuestion = questions.indexOf(currentQuestionNo);
        questionText.setText();
        correctAnswer = questions.answer;

        int number = num + 1;
        questionNoText.setText("Question Number: " + number); // update the question number displayed to match question

    }

    // creates an array of questions. This function could be used to load questions from a database
    private void createQuestions() {

            QuestionDB q1 = new QuestionDB(1, "This is easier than i thought", true);
            q1.save();
            QuestionDB q2 = new QuestionDB(1,"The sky is green", false);
            q2.save();
            QuestionDB q3 = new QuestionDB(1, "Earth is 70% land", false);
            q3.save();
            QuestionDB q4 = new QuestionDB(1, "An elephant is smaller than the moon", true);
            q4.save();
            QuestionDB q5 = new QuestionDB(1, "There are 2 hydrogen atoms in a water molecule", true);
            q5.save();

        }


    public void deleteQuestions(){
        Question.deleteAll(Question.class);
        questions.clear();
    }
}


