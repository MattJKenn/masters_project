package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.net.URISyntaxException;
import java.util.ArrayList;



/**
 * Created by owner on 13/11/2017.
 */

public class BadgeViewAdapter extends BaseAdapter{



    static int[] badge = {R.drawable.vanilla_badge1, R.drawable.vanilla_badge2, R.drawable.vanilla_badge3};
    static String[] title;
    static int[] progresses = new int[3];


    int targetQuiz = 10;
    int targetTotal = 25;

    int badgeLevels [] = {R.drawable.bronze_badge, R.drawable.silver_badge, R.drawable.gold_badge};




    Context context;


    LayoutInflater layoutInflater;

    DatabaseAccess databaseAccess;
    DatabaseOpenHelper openHelper;


    Badge quizBadgeObject, totalBadgeObject;


    ResultsScreen resultsScreen;


    ImageView badgeGraphic;
    //int[] badgeGraphics = {R.drawable.bronze_badge, R.drawable.silver_badge, R.drawable.gold_badge};



    int progressB1, progressB2, progressBTotal, progress, progressTotal;


    SharedPreferencesData progressData = new SharedPreferencesData();

    AppMain appContext;


    public BadgeViewAdapter(int[] badge, String[] titles, int [] progresses, Context context)  {

        BadgeViewAdapter.badge = badge;
        title = titles;
        BadgeViewAdapter.progresses = progresses;
        this.context = context;


        if (context != null) {
            SharedPreferencesData.setup(context);
        }
        databaseAccess = DatabaseAccess.getInstance(context);
        openHelper = DatabaseAccess.openHelper;
        databaseAccess.open();
        Cursor Badges = openHelper.getData(1);
        databaseAccess.close();



        try {updateBadgeRank(1, 0);}
        catch (URISyntaxException e) {e.printStackTrace();}

        try {updateBadgeRank(2,0);}
        catch (URISyntaxException e) {e.printStackTrace();}


        progresses[0] = progressB1;
        progresses[1] = progressB2;
        progresses[2] = progressBTotal;

        Badges.close();

    }

    //public Context getContext(){return context;}

    //public void setContext(Context context){this.context = context;}


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



        if(position != 2) progress.setText(progresses[position] + "/" + targetQuiz);
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


    void updateBadgeRank(int quizType, int score) throws URISyntaxException {
        // assign display to asset in layout

        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        ArrayList<Badge> badges = databaseAccess.getBadges();

        int index = quizType - 1;


        quizBadgeObject = badges.get(index);
        int quizBronze = 10;//quizBadgeObject.getBronze();
        int quizSilver = 25;//quizBadgeObject.getSilver();
        int quizGold = 50;//quizBadgeObject.getGold();


        totalBadgeObject = badges.get(2);
        int totalBronze = 25;//totalBadgeObject.getBronze();
        int totalSilver = 50;//totalBadgeObject.getSilver();
        int totalGold = 100;//totalBadgeObject.getGold();



        progress = progressData.update(quizType, score, context);
        progressTotal = progressData.update(3, score, context);

        if (progress < quizBronze) {targetQuiz = quizBronze;}
        if (progress >= quizBronze && progress < quizSilver) {
                badge[index] = badgeLevels[0];
                targetQuiz = quizSilver;
        }
        if (progress >= quizSilver && progress < quizGold) {
                badge[index] = badgeLevels[1];
                targetQuiz = quizGold;
        }
        if (progress >= quizGold) {
                badge[index] = badgeLevels[2];
                targetQuiz = progress;
        }

        if(progressTotal < totalBronze){targetTotal = totalBronze;}
        if(progressTotal >= totalBronze && progressTotal < totalSilver){
            badge[2] = badgeLevels[0];
            targetTotal = totalSilver;
        }
        if(progressTotal >= totalSilver && progressTotal < totalGold){
            badge[2] = badgeLevels[1];
            targetTotal = totalGold;
        }
        if(progressTotal >= totalGold){
            badge[2] = badgeLevels[2];
            targetTotal = progressTotal;
        }



        progresses[index] = progress;
        progresses[2] = progressTotal;

        databaseAccess.close();
    }


    //private void setUserData(SharedPreferences userData) {this.UserData = userData;}

}





