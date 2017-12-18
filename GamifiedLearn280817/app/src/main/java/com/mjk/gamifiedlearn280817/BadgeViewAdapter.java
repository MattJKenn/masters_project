package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by owner on 13/11/2017.
 */

public class BadgeViewAdapter extends BaseAdapter {



    Badge badgeObject;

    ArrayList<Badge> badges = new ArrayList<>();

    int badgeProgress1, badgeProgress2, badgeProgressTotal;
    int bronze [] = {5, 5, 10};
    int silver [] = {10, 10, 20};
    int gold [] = {15, 15, 30};
    int noCorrectAnswers;              // counted variables

    int target;

    int badge[];
    String title[];
    int progresses[] = {badgeProgress1, badgeProgress2, badgeProgressTotal};
    String dbtitles[] = {"Badge1Progress", "Badge2Progress", "BadgeTotalProgress"};

    //static String badgeKey;
    //static SharedPreferences preferences;


    private Context context;

    private LayoutInflater layoutInflater;

    DatabaseAccess databaseAccess;

    //GridView badgeView;
    ImageView badgeGraphic;



    public SharedPreferences sharedPreferences;


    public BadgeViewAdapter(int badge[], String titles[], int progresses[], Context context) {
        this.badge = badge;
        this.title = titles;
        this.progresses = progresses;
        this.context = context;

        receiveBadges();
        updateBadgeRank(badges);
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


    public void receiveBadges(){
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        badges = databaseAccess.getBadges();
        databaseAccess.close();
    }

    public void updateBadgeRank(ArrayList<Badge> badges){
        // assign display to asset in layout

        sharedPreferences = context.getSharedPreferences("userInfo", MODE_PRIVATE);
        /*
        SharedPreferences.Editor updater = sharedPreferences.edit();
        updater.putInt("Badge1Progress", badgeProgress1);
        updater.putInt("Badge2Progress", badgeProgress2);
        updater.putInt("BadgeTotalProgress", badgeProgressTotal);
        updater.apply();
        */


        for (int i = 1; i < badges.size(); i++) {

            target = bronze[i];

            progresses[i] = sharedPreferences.getInt(dbtitles[i], 0);

            if(progresses[i] >= bronze[i] && progresses[i] < silver[i]){
                badgeGraphic.setImageResource(R.drawable.bronze_badge);
                target = silver[i];

            }
            else if(progresses[i] >= silver[i] && progresses[i] < gold[i]) {
                badgeGraphic.setImageResource(R.drawable.silver_badge);
                target = gold[i];

            }
            else if(progresses[i] >= gold[i]){
                badgeGraphic.setImageResource(R.drawable.gold_badge);
                target = progresses[i];
            }



        }
    }
}





