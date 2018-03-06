package com.mjk.gamifiedlearn280817;

/**
 * Created by owner on 06/03/2018.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class SharedPreferencesData {

    public static final String userData = "USER_DATA";
    public static final String badge1Prog = "BADGE_1";
    public static final String badge2Prog = "BADGE_2";
    public static final String badgeTotalProg = "BADGE_TOTAL";


    public SharedPreferencesData() {
        super();
    }

    public void create(Context context){
        SharedPreferences UserData;
        SharedPreferences.Editor create;

        UserData = context.getSharedPreferences(userData, Context.MODE_PRIVATE);
        create = UserData.edit();

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

    public int update(int badge, int score, Context context) {

        SharedPreferences UserData;
        UserData = context.getSharedPreferences(userData, Context.MODE_PRIVATE);

        String name = "";
        int progress = 0;

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

        SharedPreferences.Editor updater = UserData.edit();

        updater.putInt(name, progress);

        updater.apply();

        return progress;
    }
}
