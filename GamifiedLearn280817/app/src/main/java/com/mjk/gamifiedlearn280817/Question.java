package com.mjk.gamifiedlearn280817;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by owner on 29/08/2017.
 */

/*
TODO: this is not a good way to implement your class for questions. What you had below around line 70 is a better structure.
You should be having an array of Question objects. Each question object would contain all the information that it requires
the way you have set this up is not scalable. Ideally the Question object would be parcelable so that you can pass it via intents
The question object should have at least two attributes
• question (String)
• answer (Boolean)
 you don't need anymore than that
 */


public class Question {

/*    public String[] mQuestions = {
            "This is easier than i thought",
            "The sky is green",
            "Earth is 70% land",
            "An elephant is smaller than the moon",
            "There are 2 hydrogen atoms in a water molecule",
    };                                                         // populates an array with questions

    // TODO: you shouldn't be using strings you should be using Booleans
    public String[][] mAnswerOptions = {
            {"True", "False"},
            {"True", "False"},
            {"True", "False"},
            {"True", "False"},
            {"True", "False"},
    };                                                         // populates another array with answer options

    // TODO: you shouldn't be using strings you should be using Booleans
public String[] mCorrectAnswers = {"True", "False", "False", "True", "True"};       // populates another array with correct answers

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;                    // method to retrieve a question from the array
    }

    public String getTrueChoice(int a){
        String answer = mAnswerOptions[a][0];
        return answer;                      // method to retrieve the 'true' answer option from the array
    }

    public String getFalseChoice(int a){
        String answer = mAnswerOptions[a][1];
        return answer;                      // method to retrieve the 'false' answer option from the array
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;                      // method to retrieve the correct answer from the array
    }
}
*/

    String question;
    boolean answer;

    public static ArrayList<Question> questions = new ArrayList<>();


    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    //public ArrayList<Question> getQuestion() {return questions;}


    public static ArrayList createQuestions() {
        Question q1 = new Question("This is easier than i thought", true);
        Question q2 = new Question("The sky is green", false);
        Question q3 = new Question("Earth is 70% land", false);
        Question q4 = new Question("An elephant is smaller than the moon", true);
        Question q5 = new Question("There are 2 hydrogen atoms in a water molecule", true);
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        return questions;
    }

}






