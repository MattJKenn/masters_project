package com.mjk.gamifiedlearn280817;

/**
 * Created by owner on 06/03/2018.
 */


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;


public class SharedPreferencesData extends AppCompatActivity {


    public static final String badge1Prog = "BADGE_1";
    public static final String badge2Prog = "BADGE_2";
    public static final String badgeTotalProg = "BADGE_TOTAL";


    public SharedPreferencesData () {super();}


    public void create(SharedPreferences UserData){

        SharedPreferences.Editor create = UserData.edit();

        if (!UserData.contains(badge1Prog)) {
            create.putInt(badge1Prog, 0);
        }
        if (!UserData.contains(badge2Prog)) {
            create.putInt(badge2Prog, 0);
        }
        if (!UserData.contains(badgeTotalProg)) {
            create.putInt(badgeTotalProg, 0);
        }
        create.apply();

    }


    public int update(SharedPreferences UserData, int badge, int score) {

        SharedPreferences.Editor updater;

        String name = "";
        int progress;

        switch(badge){
            case(1): name = badge1Prog;
            break;
            case(2): name = badge2Prog;
            break;
            case(3): name = badgeTotalProg;
            break;
        }


        progress = UserData.getInt(name, 0);

        progress = progress + score;

        updater = UserData.edit();

        updater.putInt(name, progress);

        updater.apply();

        return progress;
    }
}
