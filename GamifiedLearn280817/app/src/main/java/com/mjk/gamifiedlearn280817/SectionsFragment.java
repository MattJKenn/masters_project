package com.mjk.gamifiedlearn280817;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import com.mjk.gamifiedlearn280817.questiondb.QuestionDB;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragment extends Fragment {


    public SectionsFragment() {
        // Required empty public constructor
    }

    private QuestionDB questionDB;
    private ArrayList<Question> questions;

    ArrayAdapter<QuestionDB> adapter;


    Button sectionsButton1;
    Button sectionsButton2;

    int quizType;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sectionsView = inflater.inflate(R.layout.fragment_sections, container, false);

        sectionsButton1 = (Button) sectionsView.findViewById(R.id.sections_button1);
        sectionsButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                quizType = 1;

                Intent startQuiz1 =  new Intent(v.getContext(), QuestionMain.class);
                startQuiz1.putExtra("quiz_type", quizType);
                startActivity(startQuiz1);
            }
        });

        sectionsButton2 = (Button) sectionsView.findViewById(R.id.sections_button2);
        sectionsButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                quizType = 2;

                Intent startQuiz1 =  new Intent(v.getContext(), QuestionMain.class);
                startQuiz1.putExtra("quiz_type", quizType);
                startActivity(startQuiz1);
            }
        });

        return sectionsView;
    }
}
