package com.mjk.gamifiedlearn280817;


import com.orm.SugarRecord;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by owner on 29/08/2017.
 */


public class Question extends SugarRecord {

    int questionType;
    String question;
    Boolean answer;

    public Question(int questionType, String question, Boolean answer) {
        this.questionType = questionType;
        this.question = question;
        this.answer = answer;
    }
}






