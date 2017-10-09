package com.mjk.gamifiedlearn280817;


import java.util.ArrayList;

/**
 * Created by owner on 29/08/2017.
 */

public class Question {
    String question;
    Boolean answer;

    ArrayList questions = new ArrayList();


    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean getAnswer() {
        return answer;
    }

    public ArrayList createQuestions()
    {
        questions = new ArrayList<>();
        Question q1 = new Question("This is easier than i thought", true);
        Question q2 = new Question("The sky is green",false);
        Question q3 = new Question("Earth is 70% land", false);
        Question q4 = new Question("An elephant is smaller than the moon", true);
        Question q5 = new Question("There are 2 hydrogen atoms in a water molecule", true);
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        return questions;
    }
}


