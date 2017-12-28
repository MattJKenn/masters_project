package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 23/12/2017.
 */

public class SavedQViewAdapter extends CursorAdapter {



    SavedQViewAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    SQLiteDatabase database;
    DatabaseAccess databaseAccess;



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.saved_q_view_adapter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        TextView questionListView = (TextView) view.findViewById(R.id.saved_q_view);

        databaseAccess.open();
        ArrayList<String> questionTextList = databaseAccess.getQuestionTextList();
        databaseAccess.close();

        /*
        if(cursor.getCount() != 0){
            String iText = cursor.getString(cursor.getColumnIndexOrThrow(QUESTION_TEXT_COLUMN_NAME));}

        else{questionTextList[0] = "Questions You Answer Incorrectly Will Appear Here";}
        */
        questionListView.setText((CharSequence) questionTextList);

        cursor.close();
    }
}
/*

    private Context context;

    private LayoutInflater layoutInflater;

    ArrayList<Question> savedQuestions = new ArrayList<>();
    List<String> questionList = new ArrayList<>();

    DatabaseAccess databaseAccess;

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
    public void getSavedQuestions(){
        databaseAccess = new DatabaseAccess(getContext());
        databaseAccess.open();
        savedQuestions = databaseAccess.receiveSavedQuestions();
        databaseAccess.close();
    }

    public List<String> setSavedQuestions() {

        if (savedQuestions.size() > 0) {
            for (int i = 0; i < savedQuestions.size(); i++) {
                Question selectedQ = savedQuestions.get(i);
                String question = selectedQ.getQuestionText();
                questionList.add(i, question);
            }
        }
        else {
            String emptyMessage = "Questions You Answer Incorrectly Will Appear Here";
            questionList.add(0, emptyMessage);
        }
        return questionList;
    }
*/

