package com.mjk.gamifiedlearn280817;


/**
 * Created by owner on 29/08/2017.
 */

public class Question {
    String question;
    Boolean answer;



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

}


