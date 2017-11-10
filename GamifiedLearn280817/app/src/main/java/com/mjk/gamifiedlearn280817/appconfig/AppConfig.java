package com.mjk.gamifiedlearn280817.appconfig;

import android.app.Application;
import com.orm.SugarContext;

/**
 * Created by owner on 23/10/2017.
 */

public class AppConfig extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        SugarContext.init(this);
    }
}
