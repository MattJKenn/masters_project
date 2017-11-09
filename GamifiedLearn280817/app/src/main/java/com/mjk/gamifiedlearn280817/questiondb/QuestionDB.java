package com.mjk.gamifiedlearn280817.questiondb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.mjk.gamifiedlearn280817.Question;
import com.mjk.gamifiedlearn280817.QuestionMain;
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
    public int QuestionType;
    public String QuestionText;
    public Boolean CorrectAnswer;

    public QuestionDB(){}

    public void createQuestions(int questionType) {

        switch(questionType) {
            case(1):
                Question q1 = new Question(1, "This is easier than i thought", true);
                q1.save();    // NST ERROR
                Question q2 = new Question(1, "The sky is green", false);
                q2.save();
                Question q3 = new Question(1, "Earth is 70% land", false);
                q3.save();
                Question q4 = new Question(1, "An elephant is smaller than the moon", true);
                q4.save();
                Question q5 = new Question(1, "There are 2 hydrogen atoms in a water molecule", true);
                q5.save();

            case(2):
                Question q6 = new Question(2, "This is a second quiz", true);
                q6.save();
                Question q7 = new Question(2, "Spiders have 2 eyes", false);
                q7.save();
                Question q8 = new Question(2, "This is an achievement", true);
                q8.save();
                Question q9 = new Question(2, "Java is not a type of teapot", true);
                q9.save();
                Question q10 = new Question(2, "No human has eyes", false);
                q10.save();

            default:
                Question qx = new Question(1, "Nothing loaded", true);
                qx.save();
        }
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
