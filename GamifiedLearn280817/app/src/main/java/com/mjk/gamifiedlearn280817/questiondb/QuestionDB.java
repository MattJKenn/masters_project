package com.mjk.gamifiedlearn280817.questiondb;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

/**
 * Created by owner on 23/10/2017.
 */

@Table(name = "Questions_db")
public class QuestionDB extends SugarRecord {

    @Column(name = "question_text")
    private String QuestionText;

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }

    @Column(name = "correct_answer")
    private String CorrectAnswer;

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
