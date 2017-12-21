package com.mjk.gamifiedlearn280817;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SavedQFragment extends Fragment {


    public SavedQFragment() {}

    ListView savedQs;

    Question questionObject;
    List<String> questionList = new ArrayList<>();
    ArrayList<Question> savedQuestions = new ArrayList<>();


    DatabaseAccess databaseAccess = new DatabaseAccess(getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View savedQView = inflater.inflate(R.layout.fragment_saved_q, container, false);


        savedQs = (ListView) savedQView.findViewById(R.id.savedq_list);

        getSavedQuestions();

        questionList = setSavedQuestions();

        ArrayAdapter<String> questionArrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_saved_q, questionList);
        savedQs.setAdapter(questionArrayAdapter);

        return savedQView;
    }

    public void getSavedQuestions(){
        databaseAccess.open();
        savedQuestions = databaseAccess.receiveSavedQuestions();
        databaseAccess.close();
    }

    public List<String> setSavedQuestions() {

        String question = questionObject.getQuestionText();

        for (int i = 0; i < savedQuestions.size(); i++) {
            questionList.add(i, question);
        }

        return questionList;
    }
}
