package com.mjk.gamifiedlearn280817.questiondb;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;


import com.orm.dsl.Unique;




/**
 * Created by owner on 23/10/2017.
 */

public class QuestionDB extends SugarRecord implements Parcelable{

    @Unique
    public int QuestionType;
    public String QuestionText;
    public Boolean CorrectAnswer;

    public QuestionDB(){}

    public QuestionDB(int QuestionType, String QuestionText, Boolean CorrectAnswer){
        this.QuestionType = QuestionType;
        this.QuestionText = QuestionText;
        this.CorrectAnswer = CorrectAnswer;
    }

    // Getters
    public int getQuestionType() {return QuestionType;}
    public String getQuestionText() {return QuestionText;}
    public Boolean getCorrectAnswer() {return CorrectAnswer;}

    // Setters
    public void setQuestionType (int questionType) {QuestionType = questionType;}
    public void setQuestionText(String questionText) {QuestionText = questionText;}
    public void setCorrectAnswer(Boolean correctAnswer) {CorrectAnswer = correctAnswer;}




    public static void createQuestions() {

            QuestionDB q1 = new QuestionDB(1, "This is easier than i thought", true);
            q1.save();
            QuestionDB q2 = new QuestionDB(1, "The sky is green", false);
            q2.save();
            QuestionDB q3 = new QuestionDB(1, "Earth is 70% land", false);
            q3.save();
            QuestionDB q4 = new QuestionDB(1, "An elephant is smaller than the moon", true);
            q4.save();
            QuestionDB q5 = new QuestionDB(1, "There are 2 hydrogen atoms in a water molecule", true);
            q5.save();
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
