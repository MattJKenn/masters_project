package com.mjk.gamifiedlearn280817.questiondb;

import android.os.Parcel;
import android.os.Parcelable;

import com.mjk.gamifiedlearn280817.Question;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.ArrayList;


/**
 * Created by owner on 23/10/2017.
 */

public class QuestionDB extends SugarRecord implements Parcelable{

    @Unique
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
    public boolean getCorrectAnswer() {
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


    public ArrayList<Question> createQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        Question q1 = new Question(1, "This is easier than i thought", true);
        Question q2 = new Question(1, "The sky is green", false);
        Question q3 = new Question(1, "Earth is 70% land", false);
        Question q4 = new Question(1, "An elephant is smaller than the moon", true);
        Question q5 = new Question(1, "There are 2 hydrogen atoms in a water molecule", true);
        Question q6 = new Question(2, "This is the start of another set of questions", true);
        Question q7 = new Question(2, "A jellyfish has more teeth than a dog", false);
        Question q8 = new Question(2, "No human has eyes", false);
        Question q9 = new Question(2, "This statement is not false", true);
        Question q10 = new Question(2, "You have managed to get two independent quizzes running on different button clicks", true);
        Question.saveInTx(questions);
        return questions;
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
