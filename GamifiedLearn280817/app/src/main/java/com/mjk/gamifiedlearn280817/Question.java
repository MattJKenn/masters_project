package com.mjk.gamifiedlearn280817;


import android.widget.Adapter;

import com.orm.SugarRecord;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by owner on 29/08/2017.
 */


public class Question extends SugarRecord{

    private int questionType;
    private String questionText;
    private Boolean correctAnswer;

    public Question(){}

    public Question(int questionType, String question, Boolean answer) {
        this.questionType = questionType;
        this.questionText = question;
        this.correctAnswer = answer;
    }

    // Getters
    public int getQuestionType() {return questionType;}
    public String getQuestionText() {return questionText;}
    public Boolean getCorrectAnswer() {return correctAnswer;}

    // Setters
    public void setQuestionType (int QuestionType) {questionType = QuestionType;}
    public void setQuestionText(String QuestionText) {questionText = QuestionText;}
    public void setCorrectAnswer(Boolean CorrectAnswer) {correctAnswer = CorrectAnswer;}
}






