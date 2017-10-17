package com.mjk.gamifiedlearn280817;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by owner on 29/08/2017.
 */

public class Question {

    public String[] mQuestions = {
            "This is easier than i thought",
            "The sky is green",
            "Earth is 70% land",
            "An elephant is smaller than the moon",
            "There are 2 hydrogen atoms in a water molecule",
    };                                                         // populates an array with questions

    public String[][] mAnswerOptions = {
            {"True", "False"},
            {"True", "False"},
            {"True", "False"},
            {"True", "False"},
            {"True", "False"},
    };                                                         // populates another array with answer options


public String[] mCorrectAnswers = {"True", "False", "False", "True", "True"};       // populates another array with correct answers

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;                    // method to retrieve a question from the array
    }

    public String getTrueChoice(int a){
        String answer = mAnswerOptions[a][0];
        return answer;                      // method to retrieve the 'true' answer option from the array
    }

    public String getFalseChoice(int a){
        String answer = mAnswerOptions[a][1];
        return answer;                      // method to retrieve the 'false' answer option from the array
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;                      // method to retrieve the correct answer from the array
    }
}




    /*    String question;
    String answer;

    ArrayList<String> questions = new ArrayList();



  public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public ArrayList<String> getQuestion() {
        return questions;
    }


    public ArrayList createQuestions()
    {
        questions = new ArrayList<>();
        Question q1 = new Question("This is easier than i thought", "Yes");
        Question q2 = new Question("The sky is green", "No");
        Question q3 = new Question("Earth is 70% land", "No");
        Question q4 = new Question("An elephant is smaller than the moon", "Yes");
        Question q5 = new Question("There are 2 hydrogen atoms in a water molecule", "Yes");
        questions.add(q1);
        return questions;
    }
*/



