package com.mjk.gamifiedlearn280817.achievements;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by owner on 13/11/2017.
 */

public abstract class Achieve {
    // activation rules
    public static final String ACTIVE_IF_MORE_THAN = ">";
    public static final String ACTIVE_IF_LESS_THAN = "<";
    public static final String ACTIVE_IF_EQUALS_TO = "==";

    private static final int unlockValue = 25;

    private Array mProps; // dictionary of properties    // both originally Object
    private Array mAchievements; // dictionary of achievements
/*
    public Achieve() {
        mProps = { };
        mAchievements = { };
    }

    public int getValue(String theProp){
        return mProps[theProp].value;
    }

    private void setValue(String theProp, int theValue){
        // Which activation rule?
        switch(mProps[theProp].activation) {
            case Achieve.ACTIVE_IF_MORE_THAN:
                theValue = theValue > mProps[theProp].value ? theValue : mProps[theProp].value;
                break;
            case Achieve.ACTIVE_IF_LESS_THAN:
                theValue = theValue < mProps[theProp].value ? theValue : mProps[theProp].value;
                break;
        }
        mProps[theProp].value = theValue;
    }

    public void addValue(Array theProps, int theValue){
        for (int i = 0; i < theProps.length; i++) {
            String aPropName = theProps[i];
            setValue(aPropName, getValue(aPropName) + theValue);
        }
    }

    public Vector checkAchievements(){
        Vector aRet = new Vector();

        for (String n in mAchievements) {
            Achievement anAchievement = mAchievements[n];

            if (anAcheivement.unlocked == false) {
                var aActiveProps :int = 0;

                for (int p = 0; p < anAcheivement.props.length; p++) {
                    var aProp :Property = mProps[aAchivement.props[p]];

                    if (aProp.isActive()) {
                        aActiveProps++;
                    }
                }

                if (aActiveProps == aAchivement.props.length) {
                    aAchivement.unlocked = true;
                    aRet.push(aAchivement);
                }
            }
        }
        return aRet;
    }

    public void defineProperty(String name, int initialValue, String anActivationMode, int value){
        mProps[name] = new Property(name, initialValue, anActivationMode, value);
    }

    public void defineAchievement(String name, Array relatedProps){
        mAchievements[name] = new Achievement(name, relatedProps);
    }


    public void defineProperty("killedEnemies",0,ACTIVE_IF_MORE_THAN, "levelStuff") {
        if(levelIsOver()) {
            // Check for achievements, but only the ones based on properties
            // tagged with "levelStuff". All other properties will be ignored,
            // so it will not interfere with other achievements.
            checkAchievements("levelStuff");

            // Reset all properties tagged with 'levelStuff'
            resetProperties("levelStuff");
        }
    }
*/
}
