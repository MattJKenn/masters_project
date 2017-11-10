package com.mjk.gamifiedlearn280817;


/**
 * Created by owner on 20/10/2017.
 */

public enum Badge{
    BASIC, BRONZE, SILVER, GOLD;

    //private final String dscrptn;
    private int prog;

    Badge(){}

    //public String getDscrptn(){return dscrptn;}
    public int getProg(){return prog;}
};

class Badge1{

    public static final int BASIC = 0;
    public static final int BRONZE = 5;
    public static final int SILVER = 20;
    public static final int GOLD = 50;
}

class Badge2{

    public static final int BASIC = 0;
    public static final int BRONZE = 5;
    public static final int SILVER = 20;
    public static final int GOLD = 50;
}

class BadgeTotal{

    public static final int BASIC = 0;
    public static final int BRONZE = 20;
    public static final int SILVER = 50;
    public static final int GOLD = 100;
}





