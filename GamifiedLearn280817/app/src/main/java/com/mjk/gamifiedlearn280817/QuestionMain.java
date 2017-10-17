package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuestionMain extends AppCompatActivity {


    Button trueButton, falseButton, quitButton;
    TextView scoreText, questionText, questionNoText;

    private String correctAnswer;
    private String displayQuestion;

    private Question Questions = new Question();

    public int score = 0;
    private int questionNo = 0;
    private int mQuestionsLength = Questions.mQuestions.length;

    //ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_main);

        // TODO: clearly separate your code: here we are creating the buttong
        trueButton = (Button)findViewById(R.id.true_button);
        falseButton = (Button)findViewById(R.id.false_button);
        quitButton = (Button)findViewById(R.id.quit_button);

        questionText = (TextView) findViewById(R.id.quiz_textView);
        scoreText = (TextView) findViewById(R.id.score_textView);
        questionNoText = (TextView) findViewById(R.id.questionNo_textView);

        // TODO: You need to make sure that you are retreiving all information from intents before setting it
        Bundle startedQuiz = getIntent().getExtras();
        displayQuestion = startedQuiz.getString("First Question");  //receives question in intent from SectionsFragment

        scoreText.setText("Score: " + score);
        setText(0);

        //Log.d("Quiz", message);


        trueButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                // TODO: You should be comparing boolean values and not strings
               //  you should not be using == to compare strings instead you should be using .equals()
               // there is also too much code repetition here you can do this all with one function call. 

               checkQuestion(trueButton.getText().toString());

//               if (trueButton.getText() == correctAnswer){
//                   score++;
//                   scoreText.setText("Score: " + score);       // increases score if answer is correct
//               }
//
//               updateQuestion();          // move to next question
           }
       });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkQuestion(falseButton.getText().toString());

//                if (falseButton.getText() == correctAnswer){
//                    score++;
//                    scoreText.setText("Score: " + score);        // increases score if answer is correct
//                }
//                updateQuestion();
                // move to next question
            }
            });



        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }

        private void checkQuestion(String question) {
            if (question.equals(correctAnswer)) {
                score += 1;
                scoreText.setText("Score: " + score);
            }
            updateQuestion();
        }

        private void updateQuestion(){
            questionNo++;
            if (questionNo >= mQuestionsLength) {                   // if the quiz is over
                Intent displayResults = new Intent(QuestionMain.this, ResultsScreen.class);

                //TODO: you shouldnt use split words for your names in the put extra it would be better to use final_score
                // or even better should should declare them as final strings at the top of your class or in a separate class that can be accessed everywhere
                // this can help to avoid spelling mistakes and is good practice

                Log.wtf("questionMain", "final score " + score);
                displayResults.putExtra("Final Score", score);      // adds score value to intent
                startActivity(displayResults);                      // sends intent with score to ResultsScreen
                finish();
            }
            else {
                setText(questionNo);
            }
        }

        // TODO: group commonly used items together.

        private void setText(int num) {
            questionText.setText(Questions.getQuestion(num));
            trueButton.setText(Questions.getTrueChoice(num));
            falseButton.setText(Questions.getFalseChoice(num));     // populates fields with the next question's values
            correctAnswer = Questions.getCorrectAnswer(num);        // checks for the correct answer in the corresponding array
            int number = num + 1;
            questionNoText.setText("Question Number: " + number); // update the question number displayed to match questio
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
