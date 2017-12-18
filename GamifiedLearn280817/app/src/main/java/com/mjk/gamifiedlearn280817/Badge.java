package com.mjk.gamifiedlearn280817;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by owner on 13/11/2017.
 */

public class Badge extends AppCompatActivity{

    public String name;
    public int bronze, silver, gold, progress;
    //public int [] Values  = {bronze, silver, gold};
    //public boolean bronzeUnlocked, silverUnlocked, goldUnlocked = false;
    public Badge(String badgeName, int bronze, int silver, int gold, int progress)

    {
        this.name = badgeName;
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
        this.progress = progress;
    }

    public int getBronze(){return bronze;}

    public int getSilver() {return silver;}

    public int getGold() {return gold;}

    public int getProgress() {return progress;}

}
