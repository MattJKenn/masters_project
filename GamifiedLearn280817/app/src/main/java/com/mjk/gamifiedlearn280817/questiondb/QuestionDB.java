/*package com.mjk.gamifiedlearn280817.questiondb;                          abandoned for now, code for future use in Question.java?

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

/*public class QuestionDB extends SugarRecord implements Parcelable{

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
    public int getQuestionType() {return questionType;}
    public String getQuestionText() {return questionText;}
    public Boolean getCorrectAnswer() {return correctAnswer;}

    // Setters
    public void setQuestionType (int QuestionType) {questionType = QuestionType;}
    public void setQuestionText(String QuestionText) {questionText = QuestionText;}
    public void setCorrectAnswer(Boolean CorrectAnswer) {correctAnswer = CorrectAnswer;}


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

*/