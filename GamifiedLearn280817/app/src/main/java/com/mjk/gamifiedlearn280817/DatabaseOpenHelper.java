package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "AppData.db";
    private static final int DATABASE_VERSION = 1;
    private static final String QUESTION_BANK_TABLE_NAME = "QuestionBank";
    private static final String SAVED_QUESTION_TABLE_NAME = "SavedQuestions";
    private static final String BADGES_TABLE_NAME = "Badges";
    private static final String TABLE_NAMES = "QuestionBank, Badges, SavedQuestions";

    private static final String QUESTION_TYPE_COLUMN_NAME = "'QuestionType'";
    private static final String CURSOR_TYPE_COLUMN_NAME = "'_id'";
    private static final String QUESTION_TEXT_COLUMN_NAME = "'QuestionText'";
    private static final String CORRECT_ANSWER_COLUMN_NAME = "'CorrectAnswer'";
    private static final String BADGE_NAME_COLUMN_NAME = "'BadgeName'";
    private static final String BRONZE_UNLOCK_COLUMN_NAME = "'BronzeUnlock'";
    private static final String SILVER_UNLOCK_COLUMN_NAME = "'SilverUnlock'";
    private static final String GOLD_UNLOCK_COLUMN_NAME = "'GoldUnlock'";
    private static final String PROGRESS_COLUMN_NAME = "'Progress'";

    private static final String SCAN_FULL_TABLE_SQL = "SELECT * FROM ";
    public static final String[] qbColumns = {QUESTION_TYPE_COLUMN_NAME, QUESTION_TEXT_COLUMN_NAME, CORRECT_ANSWER_COLUMN_NAME};
    public static final String[] badgeColumns = {BADGE_NAME_COLUMN_NAME, BRONZE_UNLOCK_COLUMN_NAME, SILVER_UNLOCK_COLUMN_NAME,
            GOLD_UNLOCK_COLUMN_NAME, PROGRESS_COLUMN_NAME};
    public static final String[] sqColumns = {CURSOR_TYPE_COLUMN_NAME, QUESTION_TEXT_COLUMN_NAME, CORRECT_ANSWER_COLUMN_NAME};


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMES);
    }

    public Cursor getData(int type) {
        SQLiteDatabase database = this.getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String table = "";
        String[] columns = {};
        switch (type) {
            case (0):
                table = QUESTION_BANK_TABLE_NAME;
                columns = qbColumns;
                break;
            case (1):
                table = BADGES_TABLE_NAME;
                columns = badgeColumns;
                break;
            case (2):
                table = SAVED_QUESTION_TABLE_NAME;
                columns = sqColumns;
                break;
        }

        qb.setTables(table);

        Cursor cursor  = qb.query(database, columns, null, null, null, null, null);

        cursor.moveToFirst();

        return cursor;
    }

}

