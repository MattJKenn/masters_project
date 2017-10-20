package com.mjk.gamifiedlearn280817;

/**
 * Created by owner on 20/10/2017.
 */

public enum Badge {
    quiz1_Badge("Get correct answers in Quiz 1 to earn this Badge!", 0);

    private final String dscrptn;
    private int prog;

    Badge( String description, int progress){
        dscrptn = description;
        prog = progress;
    }

    public String getDscrptn(){return dscrptn;}
    public int getProg(){return prog;}
}

