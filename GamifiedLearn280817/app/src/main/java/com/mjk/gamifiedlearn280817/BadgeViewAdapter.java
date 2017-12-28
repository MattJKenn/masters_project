package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.TextView;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by owner on 13/11/2017.
 */

public class BadgeViewAdapter extends BaseAdapter {




    ArrayList<Badge> badges = new ArrayList<>();



    int target[] = new int[3];
    int badge[];
    String title[];
    int progresses [] = new int[3];


    //String dbtitles[] = {"Badge1Progress", "Badge2Progress", "BadgeTotalProgress"};
    int score;
    //static String badgeKey;
    //static SharedPreferences preferences;



    private Context context;

    private LayoutInflater layoutInflater;

    DatabaseAccess databaseAccess;

    Badge badgeObject;

    QuestionMain questionMain;

    //GridView badgeView;
    ImageView badgeGraphic;



    //public SharedPreferences sharedPreferences;


    public BadgeViewAdapter(int[] badge, String[] titles, int [] progresses, Context context) throws URISyntaxException {
        this.badge = badge;
        this.title = titles;
        this.progresses = progresses;
        this.context = context;

        receiveBadges();

        for (int i = 0; i < progresses.length; i++ ) {
            progresses[i] = 0;
            score = 0;
            updateBadgeRank(i, badges, score);
        }

    }

    @Override
    public int getCount() {
        return badge.length;
    }

    @Override
    public Object getItem(int position) {
        return badge[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View badgeView = convertView;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            badgeView = layoutInflater.inflate(R.layout.badge_view_adapter, parent, false);
        }


        // assign variables to layout assets
        badgeGraphic = (ImageView) badgeView.findViewById(R.id.badges);
        TextView titleText = (TextView) badgeView.findViewById(R.id.badge_text);
        TextView progress = (TextView) badgeView.findViewById(R.id.progress);



        badgeGraphic.setImageResource(badge[position]);
        titleText.setText(title[position]);
        progress.setText(progresses[position] + "/" + target);


        return badgeView;
    }


    public ArrayList<Badge> receiveBadges(){
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        badges = databaseAccess.getBadges();
        databaseAccess.close();

        return badges;
    }


    public void updateBadgeRank(int index, ArrayList<Badge> badges, int score) throws URISyntaxException {
        // assign display to asset in layout

        //sharedPreferences = context.getSharedPreferences("userInfo", MODE_PRIVATE);
        /*
        SharedPreferences.Editor updater = sharedPreferences.edit();
        updater.putInt("Badge1Progress", badgeProgress1);
        updater.putInt("Badge2Progress", badgeProgress2);
        updater.putInt("BadgeTotalProgress", badgeProgressTotal);
        updater.apply();

        */
        if(index < 0){index = 0;}
        badgeObject = badges.get(index);
        int bronze = badgeObject.getBronze();
        int silver = badgeObject.getSilver();
        int gold = badgeObject.getGold();
        int progress = badgeObject.getProgress();

        String dbBadgeName = "";
        switch (index){
            case(0): dbBadgeName = "'Quiz Badge 1'"; break;
            case(1): dbBadgeName = "'Quiz Badge 2'"; break;
            case(2): dbBadgeName = "'Quiz Total Badge'"; break;
        }

        progress = progress + score;

        target[index] = bronze;



            //progress = sharedPreferences.getInt(dbtitles[i], 0);

        if(progress >= bronze && progress < silver){
            badgeGraphic.setImageResource(R.drawable.bronze_badge);
            target[index] = silver;
        }
        else if(progress >= silver && progress < gold) {
            badgeGraphic.setImageResource(R.drawable.silver_badge);
            target[index] = gold;
        }
        else if(progress >= gold){
            badgeGraphic.setImageResource(R.drawable.gold_badge);
            target[index] = progress;
        }

        badgeObject.setNewProgress(progress);

        databaseAccess.open();
        databaseAccess.updateBadgeProgress(dbBadgeName, progress);
        databaseAccess.close();

        progresses[index] = progress;
    }





}





