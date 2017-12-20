package com.mjk.gamifiedlearn280817;


/**
 * Created by owner on 29/08/2017.
 */


public class Question {

    public Question() {}

    int type;
    String question;
    boolean correctAnswer;

    public Question(int type, String question, boolean answer) {
        this.type = type;
        this.question = question;
        this.correctAnswer = answer;
    }


    // Getters
    public int getQuestionType() {return type;}
    public String getQuestionText() {return question;}
    public Boolean getCorrectAnswer() {return correctAnswer;}

    // Setters
    public void setQuestionType (int QuestionType) {type = QuestionType;}
    public void setQuestionText(String QuestionText) {question = QuestionText;}
    public void setCorrectAnswer(Boolean CorrectAnswer) {correctAnswer = CorrectAnswer;}

}






