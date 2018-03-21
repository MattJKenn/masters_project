package com.mjk.gamifiedlearn280817;



import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SavedQFragment extends Fragment {


    public SavedQFragment() {}

    SectionsFragment sectionsFragment = new SectionsFragment();
    DatabaseAccess databaseAccess;
    ArrayList<Question> savedQuestions = new ArrayList<>();

    int quizType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View savedQView = inflater.inflate(R.layout.fragment_saved_q, container, false);

        Button savedQuestionQuiz = (Button) savedQView.findViewById(R.id.saved_quiz_button);
        savedQuestionQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseAccess = DatabaseAccess.getInstance(SavedQFragment.super.getContext());
                databaseAccess.open();
                savedQuestions = databaseAccess.receiveSavedQuestions();
                if (!savedQuestions.isEmpty()){
                    quizType = 3;
                    Intent startQuiz = new Intent(getActivity(), QuestionMain.class);
                    startQuiz.putExtra("quiz_type", quizType);
                    startActivity(startQuiz);
                }
                else{Toast.makeText(SavedQFragment.super.getContext(), "There are No Saved Questions to Answer!", Toast.LENGTH_SHORT).show();}

                databaseAccess.close();
            }
        });

        Button clearQuestions = (Button) savedQView.findViewById(R.id.clear_quiz_button);
        clearQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseAccess.clear();
                Toast.makeText(SavedQFragment.super.getContext(), "Saved List Cleared", Toast.LENGTH_SHORT).show();
            }
        });

        return savedQView;
    }
        /*

        ListView savedQs = (ListView) savedQView.findViewById(R.id.savedq_list);


        Cursor SavedQuestions = SavedQViewAdapter.SavedQuestions;

        SavedQViewAdapter savedQViewAdapter = new SavedQViewAdapter(getContext(), SavedQuestions, 0);

        savedQs.setAdapter(savedQViewAdapter);

        SavedQuestions.close();
        */


/*
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
}
