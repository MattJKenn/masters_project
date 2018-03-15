package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.database.Cursor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CursorAdapter;

import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by owner on 23/12/2017.
 */

public class SavedQViewAdapter extends CursorAdapter {

    private Context context;

    private LayoutInflater layoutInflater;

    ArrayList<Question> savedQuestions = new ArrayList<>();
    List<String> questionList = new ArrayList<>();

    DatabaseAccess databaseAccess;
    static Cursor SavedQuestions;
    DatabaseOpenHelper openHelper;

    private static final String NO_SAVED_QUESTIONS_TEXT = "Questions You Answer Incorrectly Will Appear Here";


    public SavedQViewAdapter(Context context, Cursor cursor, int flag) {
        super(context, cursor, flag);
        this.context = context;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View savedQView = convertView;


        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            savedQView = layoutInflater.inflate(R.layout.saved_q_view_adapter, parent, false);
        }

        return savedQView;
    }


    public void setSavedQuestions(ArrayList<Question> savedQuestions) {

        if (savedQuestions.size() > 0) {
            for (int i = 0; i < savedQuestions.size(); i++) {
                Question selectedQ = savedQuestions.get(i);
                String question = selectedQ.getQuestionText();
                questionList.add(i, question);
            }
        }
        else {
            questionList.add(0, NO_SAVED_QUESTIONS_TEXT);
        }
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.saved_q_view_adapter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        openHelper = new DatabaseOpenHelper(context);
        SavedQuestions = openHelper.getData(2);

        TextView questionListView = (TextView) view.findViewById(R.id.saved_q_adapter);

        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();

        savedQuestions = databaseAccess.receiveSavedQuestions();

        questionList = databaseAccess.getQuestionTextList();

        if (questionList.size() > 0){
            for (int i = 0; i < questionList.size(); i++){
                String question = questionList.get(i);
                questionListView.setText(question);
            }
        }
        else {questionListView.setText(NO_SAVED_QUESTIONS_TEXT);}

        SavedQuestions.close();
        databaseAccess.close();

    }


}






