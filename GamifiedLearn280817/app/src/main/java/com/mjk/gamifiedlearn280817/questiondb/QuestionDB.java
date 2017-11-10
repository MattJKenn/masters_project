package com.mjk.gamifiedlearn280817.questiondb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.mjk.gamifiedlearn280817.Question;
import com.mjk.gamifiedlearn280817.QuestionMain;
import com.mjk.gamifiedlearn280817.SectionsFragment;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;


import com.orm.dsl.Unique;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by owner on 23/10/2017.
 */

public class QuestionDB extends SugarRecord implements Parcelable{

    @Unique
    private int questionType;
    private String questionText;
    private Boolean correctAnswer;

    public QuestionDB(int questionType, String question, Boolean answer) {
        this.questionType = questionType;
        this.questionText = question;
        this.correctAnswer = answer;
    }

    // Getters
    //public int getQuestionType() {return questionType;}
    public String getQuestionText() {return questionText;}
    public Boolean getCorrectAnswer() {return correctAnswer;}

    // Setters
    //public void setQuestionType (int QuestionType) {questionType = QuestionType;}
    public void setQuestionText(String QuestionText) {questionText = QuestionText;}
    public void setCorrectAnswer(Boolean CorrectAnswer) {correctAnswer = CorrectAnswer;}


    public QuestionDB(){}

    public void createQuestions(int questionType) {
        switch(questionType) {
            case(1):
            QuestionDB q1 = new QuestionDB(1, "This is easier than i thought", true);
            q1.save();    // NST ERROR
            QuestionDB q2 = new QuestionDB(1, "The sky is green", false);
            q2.save();
            QuestionDB q3 = new QuestionDB(1, "Earth is 70% land", false);
            q3.save();
            QuestionDB q4 = new QuestionDB(1, "An elephant is smaller than the moon", true);
            q4.save();
            QuestionDB q5 = new QuestionDB(1, "There are 2 hydrogen atoms in a water molecule", true);
            q5.save();

            case(2):
            QuestionDB q6 = new QuestionDB(2, "This is a second quiz", true);
            q6.save();
            QuestionDB q7 = new QuestionDB(2, "Spiders have 2 eyes", false);
            q7.save();
            QuestionDB q8 = new QuestionDB(2, "This is an achievement", true);
            q8.save();
            QuestionDB q9 = new QuestionDB(2, "Java is not a type of teapot", true);
            q9.save();
            QuestionDB q10 = new QuestionDB(2, "No human has eyes", false);
            q10.save();
        }
    }


    private QuestionDB (Parcel in){
        questionType = in.readInt();
        questionText = in.readString();
        correctAnswer = in.readByte() != 0;
    }


    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeInt(questionType);
        parcel.writeString(questionText);
        parcel.writeByte((byte) (correctAnswer ? 0:1));
    }

    public static final Parcelable.Creator<QuestionDB> CREATOR = new Parcelable.Creator<QuestionDB>(){

        @Override
        public QuestionDB createFromParcel(Parcel source) {
            return new QuestionDB(source);
        }

        @Override
        public QuestionDB[] newArray(int size) {
            return new QuestionDB[size];
        }
    };



}
