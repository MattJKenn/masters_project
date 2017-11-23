package com.mjk.gamifiedlearn280817;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment{

    GridView badgeView;

    String badgeTitle[] = {"Quiz Badge 1", "Quiz Badge 2", "Quiz Total Badge"};

    int badge[] = {R.drawable.vanilla_badge1, R.drawable.vanilla_badge2, R.drawable.vanilla_badge3};

    int progress [] = {10, 50, 100};

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View profileView = inflater.inflate(R.layout.fragment_profile, container, false);

        badgeView = (GridView) profileView.findViewById(R.id.badge_view);
        BadgeViewAdapter badgeViewAdapter = new BadgeViewAdapter(badge, badgeTitle, progress, ProfileFragment.super.getContext());

        badgeView.setAdapter(badgeViewAdapter);

        badgeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ProfileFragment.super.getContext(), "Clicked Badge", Toast.LENGTH_LONG).show();
            }
        });


        return profileView;
    }
}
