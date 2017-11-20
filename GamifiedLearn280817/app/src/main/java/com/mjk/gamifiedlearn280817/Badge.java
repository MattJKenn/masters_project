package com.mjk.gamifiedlearn280817;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by owner on 13/11/2017.
 */

public class Badge extends AppCompatActivity{

    public String name;
    public int progress, bronze, silver, gold;
    public int [] Values  = {progress, bronze, silver, gold};
    public boolean bronzeUnlocked, silverUnlocked, goldUnlocked = false;
    public Badge(
            String badgeName, int [] Values,
            boolean badgeBronzeUnlocked, boolean badgeSilverUnlocked, boolean badgeGoldUnlocked)

    {
        this.name = badgeName;
        this.Values = Values;
        this.bronzeUnlocked = badgeBronzeUnlocked;
        this.silverUnlocked = badgeSilverUnlocked;
        this.goldUnlocked = badgeGoldUnlocked;
    }

}
