package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 23/12/2017.
 */

public class SavedQViewAdapter extends ArrayAdapter<String> {


    private Context context;

    private LayoutInflater layoutInflater;

    ArrayList<Question> savedQuestions = new ArrayList<>();
    List<String> questionList = new ArrayList<>();

    DatabaseAccess databaseAccess;


    public SavedQViewAdapter(Context context, List<String> questionList){
        super(context, 0, questionList);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View savedQView = convertView;

        //ListView questionListView = (ListView) convertView.findViewById(R.id.savedq_list);

        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            savedQView = layoutInflater.inflate(R.layout.saved_q_view_adapter, parent, false);
        }


        getSavedQuestions();

        questionList = setSavedQuestions();



        return convertView;
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

}
