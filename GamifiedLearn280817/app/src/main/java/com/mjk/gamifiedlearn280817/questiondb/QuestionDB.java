package com.mjk.gamifiedlearn280817.questiondb;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;


/**
 * Created by owner on 23/10/2017.
 */


public class QuestionDB extends SugarRecord implements Parcelable{


    private String QuestionText;
    private Boolean CorrectAnswer;

    public QuestionDB(){}

    public QuestionDB(String QuestionText, Boolean CorrectAnswer){
        this.QuestionText = QuestionText;
        this.CorrectAnswer = CorrectAnswer;
    }

    // Getters
    public String getQuestionText() {return QuestionText;}
    public boolean getCorrectAnswer() {
        return CorrectAnswer;
    }

    // Setters

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }
    public void setCorrectAnswer(Boolean correctAnswer) {CorrectAnswer = correctAnswer;}

    private QuestionDB (Parcel in){
        QuestionText = in.readString();
        CorrectAnswer = in.readByte() != 0;
    }


    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeString(QuestionText);
        parcel.writeByte((byte) (CorrectAnswer ? 0:1));
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
