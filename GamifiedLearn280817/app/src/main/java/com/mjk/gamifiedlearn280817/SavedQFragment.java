package com.mjk.gamifiedlearn280817;


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
public class SavedQFragment extends Fragment {


    public SavedQFragment() {
        // Required empty public constructor
    }

    Button savedQButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View savedQView = inflater.inflate(R.layout.fragment_saved_q, container, false);

        savedQButton = (Button) savedQView.findViewById(R.id.saved_q_button);
        savedQButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("savedQFragment","clicked saved button");
            }
        });
        return savedQView;
    }
}
