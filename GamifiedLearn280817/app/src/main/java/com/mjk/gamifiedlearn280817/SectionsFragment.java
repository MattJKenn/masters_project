package com.mjk.gamifiedlearn280817;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import com.mjk.gamifiedlearn280817.questiondb.QuestionDB;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragment extends Fragment {


    public SectionsFragment() {
        // Required empty public constructor
    }

    private QuestionDB questionDB;
    private List<QuestionDB> questions;
    //private AdapterView questionAdapterView;


    Button sectionsButton;

    int quizType;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sectionsView = inflater.inflate(R.layout.fragment_sections, container, false);

        sectionsButton = (Button) sectionsView.findViewById(R.id.sections_button);
        sectionsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent startQuiz1 =  new Intent(v.getContext(), QuestionMain.class);
                startQuiz1.putExtra("quiz_type", quizType);
                startActivity(startQuiz1);
            }
        });
        return sectionsView;
    }



}
