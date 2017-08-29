package com.mjk.gamifiedlearn280817;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragment extends Fragment {


    public SectionsFragment() {
        // Required empty public constructor
    }

    Button sectionsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sectionsView = inflater.inflate(R.layout.fragment_sections, container, false);

        sectionsButton = (Button) sectionsView.findViewById(R.id.sections_button);
        sectionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                Intent startQuiz =  new Intent(v.getContext(), QuestionMain.class);
                startActivity(startQuiz);
            }
        });
        return sectionsView;
    }

}
