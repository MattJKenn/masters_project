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

    int badge[];
    String title[];
    int progresses[];

    int badgeProgress;
    int bronze;
    int silver;
    int gold;
    int noCorrectAnswers;              // counted variables

    int target = bronze;

    //static String badgeKey;
    //static SharedPreferences preferences;


    private Context context;

    private LayoutInflater layoutInflater;

    DatabaseAccess databaseAccess;

    ArrayList<Badge> badges = new ArrayList<>();

    Badge badgeObject;


    // Badge badge1, badge2, badgetotal;              // badge object variables

        /*
    int[] badge1Values = {0, 10, 25, 50};
    int[] badge2Values = {0, 10, 25, 50};
    int[] badgeTotalValues = {0, 25, 50, 100};
        */

    //GridView badgeView;
    ImageView badgeGraphic;

    SharedPreferences sharedPreferences;


    public BadgeViewAdapter(int badges[], String titles[], int progresses[], Context context) {
        this.badge = badges;
        this.title = titles;
        this.progresses = progresses;
        this.context = context;
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

        SharedPreferences sharedPreferences = context.getSharedPreferences("userData", MODE_PRIVATE);
        SharedPreferences.Editor updater = sharedPreferences.edit();

        updater.putInt("Badge1Progress", 0);
        updater.putInt("Badge2Progress", 0);
        updater.putInt("BadgeTotalProgress", 0);

        updater.apply();

        // assign variables to layout assets
        badgeGraphic = (ImageView) badgeView.findViewById(R.id.badges);
        TextView titleText = (TextView) badgeView.findViewById(R.id.badge_text);
        TextView progress = (TextView) badgeView.findViewById(R.id.progress);

        receiveBadges();
        updateBadgeRank();


        badgeGraphic.setImageResource(badge[position]);
        titleText.setText(title[position]);
        progress.setText(progresses[position] + "/" + target);

        /*
        badge1 = new Badge("Quiz 1 Badge", bronze,
                silver, gold);
        badge2 = new Badge("Quiz 2 Badge", badge2Values,
                false, false, false);
        badgetotal = new Badge("Quiz Total Badge", badgeTotalValues,
                false, false, false);
        */
        //badgeProgressPref = getSharedPreferences("progress", MODE_PRIVATE)

        return badgeView;
    }


    public void receiveBadges(){
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        badges = databaseAccess.getBadges();
        System.out.println(badges);
        databaseAccess.close();
    }

    public void updateBadgeRank(){
        // assign display to asset in layout

            //noCorrectAnswers =;   SharedPreferences!

            badgeProgress = updateBadgeProgress(noCorrectAnswers);         // increment progress

            // check on new progress amount for unlock thresholds
            if(badgeProgress >= bronze && badgeProgress < silver){
                badgeGraphic.setImageResource(R.drawable.bronze_badge);
                target = silver;
            }
            else if(badgeProgress >= silver && badgeProgress < gold) {
                badgeGraphic.setImageResource(R.drawable.silver_badge);
                target = gold;

            }
            else if(badgeProgress >= gold){
                badgeGraphic.setImageResource(R.drawable.gold_badge);
            }
            // save changes to user settings
        /*SharedPreferences.Editor changeBadgeRank = badgeRankPref.edit();
        changeBadgeRank.putBoolean("badge_rank_unlocked", rankUnlocked);
        changeBadgeRank.apply();
`       */
        }

    public int updateBadgeProgress(int addedProgress){// get the number of correct answers

        badgeProgress = badgeProgress + addedProgress;     // add correct answers to running total

        /*SharedPreferences.Editor changeBadgeProgress = preferences.edit();
        changeBadgeProgress.putInt(badgeKey, badgeProgress);
        changeBadgeProgress.apply();                // save progress in user settings
        */
        return badgeProgress;

    }
}





