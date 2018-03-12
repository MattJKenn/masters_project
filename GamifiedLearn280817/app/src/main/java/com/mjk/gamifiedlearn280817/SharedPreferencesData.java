package com.mjk.gamifiedlearn280817;

/**
 * Created by owner on 06/03/2018.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class SharedPreferencesData extends AppCompatActivity {

    public static final String userData = "USER_DATA";
    public static final String badge1Prog = "BADGE_1";
    public static final String badge2Prog = "BADGE_2";
    public static final String badgeTotalProg = "BADGE_TOTAL";
    private Context context = null;


    public SharedPreferencesData () {super();}

    static void setup(Context context) {
        SharedPreferences UserData = context.getSharedPreferences(userData, MODE_PRIVATE);
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


    public void create(Context context){
        this.context = context;

        if(this.context != null) {
                SharedPreferences UserData = this.context.getSharedPreferences(userData, MODE_PRIVATE);
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

        } else {
            Log.e("sharedPref","context is null");
        }
    }


    public int update(int badge, int score, Context context) {

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

        SharedPreferences UserData = context.getSharedPreferences(userData, MODE_PRIVATE);

        progress = UserData.getInt(name, 0);

        progress = progress + score;



        SharedPreferences.Editor updater = UserData.edit();

        updater.putInt(name, progress);

        updater.apply();

        return progress;
    }
}
