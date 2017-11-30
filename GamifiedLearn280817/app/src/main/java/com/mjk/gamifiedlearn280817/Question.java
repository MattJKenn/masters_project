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
}
/*
    // Getters
    //public int getQuestionType() {return questionType;}
    public String getQuestionText() {return questionText;}
    public Boolean getCorrectAnswer() {return correctAnswer;}

    // Setters
    //public void setQuestionType (int QuestionType) {questionType = QuestionType;}
    public void setQuestionText(String QuestionText) {questionText = QuestionText;}
    public void setCorrectAnswer(Boolean CorrectAnswer) {correctAnswer = CorrectAnswer;}

}
*/





