package com.mjk.gamifiedlearn280817;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import com.mjk.gamifiedlearn280817.questiondb.QuestionDB;

public class QuestionMain extends AppCompatActivity {



    private Button trueButton, falseButton, quitButton;
    private TextView scoreText, questionText, questionNoText;

    private Boolean correctAnswer;
    private Question currentQuestion;
    private int score = 0;
    private int currentQuestionNo = 0;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        // create your questions there is no real reason to pass them via an intent
        questions = createQuestions();

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
        currentQuestion = questions.get(num);
        questionText.setText(currentQuestion.question);
        correctAnswer = currentQuestion.answer;

        int number = num + 1;
        questionNoText.setText("Question Number: " + number); // update the question number displayed to match question

    }

    // creates an array of questions. This function could be used to load questions from a database

    public static ArrayList<Question> createQuestions() {  // Parcelable.Creator type??
        ArrayList<Question> questions = new ArrayList<>();
        Question q1 = new Question(1, "This is easier than i thought", true);
        Question q2 = new Question(1, "The sky is green", false);
        Question q3 = new Question(1, "Earth is 70% land", false);
        Question q4 = new Question(1, "An elephant is smaller than the moon", true);
        Question q5 = new Question(1, "There are 2 hydrogen atoms in a water molecule", true);
        Question q6 = new Question(2, "This is the start of another set of questions", true);
        Question q7 = new Question(2, "A jellyfish has more teeth than a dog", false);
        Question q8 = new Question(2, "No human has eyes", false);
        Question q9 = new Question(2, "This statement is not false", true);
        Question q10 = new Question(2, "You are on the last question of this quiz", true);
        questions.add(q1);  //q1.save(), etc instead?
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);
        questions.add(q10);
        return questions;
    }
}
