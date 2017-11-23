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

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by owner on 13/11/2017.
 */

public class BadgeLogic extends ProfileFragment{


    public BadgeLogic() {}

    public SharedPreferences badgeRankPref, badgeProgressPref;              // user data for progress variables

    int badgeProgress, bronze, silver, gold, noCorrectAnswers;              // counted variables

    public int [] Values  = {badgeProgress, bronze, silver, gold};          // individual properties for each badge

    boolean bronzeUnlocked, silverUnlocked, goldUnlocked, rankUnlocked= false;       // check variables for rank unlocks

    ImageView badge;                            // badge display variable





    public void updateBadgeRank(ImageView badgeView){

        badgeView = (ImageView) badge.findViewById(R.id.badge_view);  // assign display to asset in layout

        badgeProgress = updateBadgeProgress();         // increment progress

        // check on new progress amount for unlock thresholds
        if(badgeProgress >= bronze && badgeProgress < silver){
            rankUnlocked = bronzeUnlocked = true;
            badge.setImageResource(R.drawable.bronze_badge);
        }
        else if(badgeProgress >= silver && badgeProgress < gold) {
            rankUnlocked = silverUnlocked = true;
            badge.setImageResource(R.drawable.silver_badge);
        }
        else if(badgeProgress >= gold){
            rankUnlocked = goldUnlocked = true;
            badge.setImageResource(R.drawable.gold_badge);
        }
        // save changes to user settings
        SharedPreferences.Editor changeBadgeRank = badgeRankPref.edit();
        changeBadgeRank.putBoolean("badge_rank_unlocked", rankUnlocked);
        changeBadgeRank.apply();

    }

    public int updateBadgeProgress(){
        int gainedProgress =  noCorrectAnswers;      // get the number of correct answers
        badgeProgress = badgeProgress + gainedProgress;     // add correct answers to running total
        SharedPreferences.Editor changeBadgeProgress = badgeProgressPref.edit();
        changeBadgeProgress.putInt("progress", badgeProgress);
        changeBadgeProgress.apply();                // save progress in user settings
        return badgeProgress;
    }

}
