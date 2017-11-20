package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;




/**
 * Created by owner on 13/11/2017.
 */

public abstract class BadgeLogic extends ProfileFragment{


    public BadgeLogic() {}

    public SharedPreferences badgeRankPref, badgeProgressPref;              // user data for progress variables

    int badgeProgress, bronze, silver, gold, noCorrectAnswers;              // counted variables

    public int [] Values  = {badgeProgress, bronze, silver, gold};          // individual properties for each badge

    boolean bronzeUnlocked, silverUnlocked, goldUnlocked, rankUnlocked= false;       // check variables for rank unlocks

    Badge badge1, badge2, badgetotal;              // badge object variables

    ImageView badge;                            // badge display variable




    public void updateBadgeRank(ImageView badge){

        badge = (ImageView) badge.findViewById(R.id.badge_view);  // assign display to asset in layout

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


    public View setBadges(View badge) {           // set up badge objects   (Call where?)
        badge1 = new Badge("Quiz 1 Badge", Values,
                            false, false, false);
        badge2 = new Badge("Quiz 2 Badge", Values,
                            false, false, false);
        badgetotal = new Badge("Quiz Total Badge", Values,
                                false,false, false);
        return badge;
    }



}
