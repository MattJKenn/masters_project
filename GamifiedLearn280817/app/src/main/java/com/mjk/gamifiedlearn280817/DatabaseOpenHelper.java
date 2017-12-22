package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseOpenHelper extends SQLiteAssetHelper {
    public static final String DATABASE_NAME = "AppData.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAMES = "QuestionBank, Badges, SavedQuestions";



    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMES);
    }

}
