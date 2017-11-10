package com.mjk.gamifiedlearn280817;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragment extends Fragment {


    public SectionsFragment() {
        // Required empty public constructor
    }

    //private Question Questions = new Question();
    Button sectionsButton1;
    Button sectionsButton2;

    int quizType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sectionsView = inflater.inflate(R.layout.fragment_sections, container, false);

        sectionsButton1 = (Button) sectionsView.findViewById(R.id.sections_button1);
        sectionsButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                quizType = 1;
                startQuiz();
            }
        });

        sectionsButton2 = (Button) sectionsView.findViewById(R.id.sections_button2);
        sectionsButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                quizType = 2;
                startQuiz();
            }
        });

        return sectionsView;
    }

    private void startQuiz(){
        Intent startQuiz = new Intent(getContext(), QuestionMain.class);
        startQuiz.putExtra("quiz_type", quizType);
        startActivity(startQuiz);
    }
}
