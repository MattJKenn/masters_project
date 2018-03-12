package com.mjk.gamifiedlearn280817;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by owner on 13/11/2017.
 */

public class Badge extends AppCompatActivity{

    public String name;
    public int bronze, silver, gold;

    //public int [] Values  = {bronze, silver, gold};
    //public boolean bronzeUnlocked, silverUnlocked, goldUnlocked = false;
    public Badge(String badgeName, int bronze, int silver, int gold)

    {
        this.name = badgeName;
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
    }



    public int getBronze(){return bronze;}

    public int getSilver() {return silver;}

    public int getGold() {return gold;}





    //public void setNewProgress(int newProgress){this.progress = newProgress;}
    /*

    public int getValue(int type, boolean total){

        int value = 0;

        switch (type){
            case(0): value = getBronze(); break;
            case(1): value = getSilver(); break;
            case(2): value = getGold(); break;
            case(3): value = getProgress(); break;
        }



        return value;
    } */

}
