package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.mjk.gamifiedlearn280817.AppMain.badge1Prog;
import static com.mjk.gamifiedlearn280817.AppMain.badge2Prog;
import static com.mjk.gamifiedlearn280817.AppMain.badgeTotalProg;
import static com.mjk.gamifiedlearn280817.AppMain.userData;


/**
 * Created by owner on 13/11/2017.
 */

public class BadgeLogic {


    public BadgeLogic(int[] badges, String[] titles, List<Integer> progresses, Context context) {
    }
    //public static SharedPreferences userSettings;              // user data for progress variables
/*
    int badgeProgress;
    static int bronze;
    static int silver;
    static int gold;
    int noCorrectAnswers;              // counted variables

    int target = bronze;

    static String badgeKey;
    static SharedPreferences preferences;

    //public int [] Values  = {bronze, silver, gold};          // individual properties for each badge

    //boolean bronzeUnlocked, silverUnlocked, goldUnlocked, rankUnlocked= false;       // check variables for rank unlocks

    ImageView badge;                            // badge display variable



    public void updateBadgeRank(){

        badgeView = (GridView) badge.findViewById(R.id.badges);  // assign display to asset in layout

        //DatabaseAccess.getBadges();

        //badgeKey = ;
        badgeProgress = updateBadgeProgress(noCorrectAnswers /*, badgeKey*/;         // increment progress

        // check on new progress amount for unlock thresholds
    /*
        if(badgeProgress >= bronze && badgeProgress < silver){
            badge.setImageResource(R.drawable.bronze_badge);
            target = silver;
        }
        else if(badgeProgress >= silver && badgeProgress < gold) {
            badge.setImageResource(R.drawable.silver_badge);
            target = gold;

        }
        else if(badgeProgress >= gold){
            badge.setImageResource(R.drawable.gold_badge);
        }
        // save changes to user settings
        /*SharedPreferences.Editor changeBadgeRank = badgeRankPref.edit();
        changeBadgeRank.putBoolean("badge_rank_unlocked", rankUnlocked);
        changeBadgeRank.apply();
`       */
    }
    /*
    public int updateBadgeProgress(int addedProgress){// get the number of correct answers

        badgeProgress = badgeProgress + addedProgress;     // add correct answers to running total

        /*SharedPreferences.Editor changeBadgeProgress = preferences.edit();
        changeBadgeProgress.putInt(badgeKey, badgeProgress);
        changeBadgeProgress.apply();                // save progress in user settings
        */
    /*
        return badgeProgress;

                }
}
*/
