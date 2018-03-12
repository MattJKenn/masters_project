package com.mjk.gamifiedlearn280817.achievements;



/**
 * Created by owner on 20/10/2017.
 */

public class Property {

        private String mName;
        private int mValue;
        private String mActivation;
        private int mActivationValue;
        private int mInitialValue;

        public Property(String name, int initialValue, String activation, int activationValue) {
            mName = name;
            mActivation = activation;
            mActivationValue = activationValue;
            mInitialValue = initialValue;
        }

    public Boolean isActive(){
        Boolean aRet = false;

        switch(mActivation) {
            case Achieve.ACTIVE_IF_MORE_THAN: aRet = mValue > mActivationValue; break;
            case Achieve.ACTIVE_IF_LESS_THAN: aRet = mValue < mActivationValue; break;
            case Achieve.ACTIVE_IF_EQUALS_TO: aRet = mValue == mActivationValue; break;
        }

        return aRet;
    }

}





