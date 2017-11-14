package com.mjk.gamifiedlearn280817;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by owner on 13/11/2017.
 */

public class BadgeLogic extends AppCompatActivity {



    public BadgeLogic() {}

    public void setBadges() {
        Badge badge1 = new Badge("Quiz 1 Badge", 0, 0, 10, 25, 50);
        Badge badge2 = new Badge("Quiz 2 Badge", 0, 0, 10, 25, 50);
        Badge badgetotal = new Badge("Quiz Total Badge", 0, 0, 20, 50, 100);
    }

}
