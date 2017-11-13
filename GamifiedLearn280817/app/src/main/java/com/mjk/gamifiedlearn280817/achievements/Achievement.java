package com.mjk.gamifiedlearn280817.achievements;

import java.lang.reflect.Array;

/**
 * Created by owner on 13/11/2017.
 */

public class Achievement {
    private String mName; // achievement name
    private Array mProps; // array of related properties
    private Boolean mUnlocked; // achievement is unlocked or not

    public Achievement(String name, Array relatedProps) {
        mName = name;
        mProps = relatedProps;
        mUnlocked = false;
    }
}


