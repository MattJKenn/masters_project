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



    static int[] badge = {R.drawable.vanilla_badge1, R.drawable.vanilla_badge2, R.drawable.vanilla_badge3};
    static String[] title;
    static int[] progresses  = new int[3];

    int targetQuiz, targetTotal;

    int badgeLevels [] = {R.drawable.bronze_badge, R.drawable.silver_badge, R.drawable.gold_badge};
    //String dbtitles[] = {"Badge1Progress", "Badge2Progress", "BadgeTotalProgress"};
    //static String badgeKey;
    //static SharedPreferences preferences;



    private Context context;

    private LayoutInflater layoutInflater;

    DatabaseAccess databaseAccess;

    Badge quizBadgeObject, totalBadgeObject;

    QuestionMain questionMain;

    //GridView badgeView;
    ImageView badgeGraphic;
    //int[] badgeGraphics = {R.drawable.bronze_badge, R.drawable.silver_badge, R.drawable.gold_badge};



    //public SharedPreferences sharedPreferences;


    public BadgeViewAdapter(int[] badge, String[] titles, int [] progresses, Context context) throws URISyntaxException {
        this.badge = badge;
        this.title = titles;
        this.progresses = progresses;
        this.context = context;

        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        badges = databaseAccess.getBadges();
        /*
        for (int i = 0; i < progresses.length; i++ ) {
            progresses[i] = 0;
            score[i] = 0;
            updateBadgeRank(i, score);
        }
        */
        databaseAccess.close();

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



        boolean quizBadgeScanned = (progresses[position] != 2);

        badgeGraphic.setImageResource(badge[position]);
        titleText.setText(title[position]);

        if(quizBadgeScanned) progress.setText(progresses[position] + "/" + targetQuiz);
        else{progress.setText(progresses[2] + "/" + targetTotal);}

        return badgeView;
    }


    /*
    public ArrayList<Badge> receiveBadges(){
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        badges = databaseAccess.getBadges();
        databaseAccess.close();

        return badges;
    }
    */

    public void updateBadgeRank(int quizType, int score) throws URISyntaxException {
        // assign display to asset in layout
        badges = databaseAccess.getBadges();
        //sharedPreferences = context.getSharedPreferences("userInfo", MODE_PRIVATE);
        /*
        SharedPreferences.Editor updater = sharedPreferences.edit();
        updater.putInt("Badge1Progress", badgeProgress1);
        updater.putInt("Badge2Progress", badgeProgress2);
        updater.putInt("BadgeTotalProgress", badgeProgressTotal);
        updater.apply();

        */

        int index = quizType - 1;

        quizBadgeObject = badges.get(index);
        int quizBronze = quizBadgeObject.bronze;
        int quizSilver = quizBadgeObject.silver;
        int quizGold = quizBadgeObject.gold;
        int quizProgress = quizBadgeObject.progress;

        totalBadgeObject = badges.get(2);
        int totalBronze = totalBadgeObject.bronze;
        int totalSilver = totalBadgeObject.silver;
        int totalGold = totalBadgeObject.gold;
        int totalProgress = totalBadgeObject.progress;

        String dbBadgeName = "";


        switch (quizType){
            case(1): dbBadgeName = "'Quiz Badge 1'"; break;
            case(2): dbBadgeName = "'Quiz Badge 2'"; break;
        }


        quizProgress = quizProgress + score;
        totalProgress = totalProgress + score;


            //progress = sharedPreferences.getInt(dbtitles[i], 0);


        if(quizProgress < quizBronze){targetQuiz = quizBronze;}
        else if(quizProgress >= quizBronze && quizProgress < quizSilver){
            badge[index] = badgeLevels[0];
            targetQuiz = quizSilver;
        }
        else if(quizProgress >= quizSilver && quizProgress < quizGold) {
            badge[index] = badgeLevels[1];
            targetQuiz = quizGold;
        }
        else if(quizProgress >= quizGold){
            badge[index] = badgeLevels[2];
            targetQuiz = quizProgress;
        }

        if(totalProgress < totalBronze){targetTotal = totalBronze;}
        else if(totalProgress >= totalBronze && totalProgress < totalSilver){
            badge[2] = badgeLevels[0];
            targetTotal = totalSilver;
        }
        else if(totalProgress >= totalSilver && totalProgress < totalGold){
            badge[2] = badgeLevels[1];
            targetTotal = totalGold;
        }
        else if(totalProgress >= totalGold){
            badge[2] = badgeLevels[2];
            targetTotal = totalProgress;
        }



        //badgeObject.setNewProgress(progress[index]);

        databaseAccess.updateBadgeProgress(dbBadgeName, quizProgress);
        databaseAccess.updateBadgeProgress("Quiz Total Badge", totalProgress);

        progresses[index] = quizProgress;
        progresses[2] = totalProgress;
    }






}





