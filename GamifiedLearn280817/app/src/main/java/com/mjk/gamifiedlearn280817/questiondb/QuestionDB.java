package com.mjk.gamifiedlearn280817.questiondb;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;


/**
 * Created by owner on 23/10/2017.
 */


public class QuestionDB extends SugarRecord implements Parcelable{


    private int QuestionType;
    private String QuestionText;
    private Boolean CorrectAnswer;

    public QuestionDB(){}

    public QuestionDB(int QuestionType, String QuestionText, Boolean CorrectAnswer){
        this.QuestionType = QuestionType;
        this.QuestionText = QuestionText;
        this.CorrectAnswer = CorrectAnswer;
    }

    // Getters
    public int getQuestionType(){return QuestionType;}
    public String getQuestionText() {return QuestionText;}
    public Boolean getCorrectAnswer() {
        return CorrectAnswer;
    }

    // Setters
    public void setQuestionType(int questionType ){QuestionType = questionType;}
    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }
    public void setCorrectAnswer(Boolean correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    private QuestionDB (Parcel in){
        QuestionType = in.readInt();
        QuestionText = in.readString();
        CorrectAnswer = in.readByte() != 0;
    }


    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeInt(QuestionType);
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
