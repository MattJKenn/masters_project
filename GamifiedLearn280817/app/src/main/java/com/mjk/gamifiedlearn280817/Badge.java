package com.mjk.gamifiedlearn280817;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by owner on 13/11/2017.
 */

public class Badge extends AppCompatActivity{

    public String name;
    public int progress;
    public int currentValue;

    public int bronzeUnlock;
    public int silverUnlock;
    public int goldUnlock;

    public Badge(String badgeName, int badgeProgress, int badgeCurrentValue,
                 int badgeBronzeUnlock, int badgeSilverUnlock, int badgeGoldUnlock) {
        this.name = badgeName;
        this.progress = badgeProgress;
        this.currentValue = badgeCurrentValue;

        this.bronzeUnlock = badgeBronzeUnlock;
        this.silverUnlock = badgeSilverUnlock;
        this.goldUnlock = badgeGoldUnlock;
    }


}
