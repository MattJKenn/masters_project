package com.mjk.gamifiedlearn280817;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

public class DatabaseAccess {
    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    Question questionObject = new Question();

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */

    public DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public ArrayList<Question> getQuestions(int qType) {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        String[] columns = new String[]{"QuestionType", "QuestionText", "CorrectAnswer"};

        Cursor cursor = database.query("QuestionBank", columns, "QuestionType =" + qType + "",
                null, null, null, null);


        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int iQType = cursor.getColumnIndex("QuestionType");
            int iQText = cursor.getColumnIndex("QuestionText");
            int iCorrectAns = cursor.getColumnIndex("CorrectAnswer");


            do {
                int type = cursor.getInt(iQType);
                String text = cursor.getString(iQText);
                int rawAnswer = cursor.getInt(iCorrectAns);
                boolean answer = (rawAnswer != 0);

                Question question = new Question(type, text, answer);
                questionArrayList.add(question);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        return questionArrayList;
    }


    public ArrayList<Badge> getBadges() {
        ArrayList<Badge> badgeList = new ArrayList<>();
        String[] columns = new String[]{"BadgeName", "BronzeUnlock", "SilverUnlock", "GoldUnlock", "Progress"};

        Cursor cursor = database.query("Badges", columns, null,
                null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int iName = cursor.getColumnIndex("BadgeName");
            int iBronze = cursor.getColumnIndex("BronzeUnlock");
            int iSilver = cursor.getColumnIndex("SilverUnlock");
            int iGold = cursor.getColumnIndex("GoldUnlock");
            int iProg = cursor.getColumnIndex("Progress");

            do {
                String badgeName = cursor.getString(iName);
                int bronzeUnlock = cursor.getInt(iBronze);
                int silverUnlock = cursor.getInt(iSilver);
                int goldUnlock = cursor.getInt(iGold);
                int progress = cursor.getInt(iProg);


                Badge badge = new Badge(badgeName, bronzeUnlock, silverUnlock, goldUnlock, progress);
                badgeList.add(badge);
            }
            while (cursor.moveToNext());

            cursor.close();
        }

        return badgeList;
    }

    public void updateBadgeProgress(String badgeName, int newProgress){
        database.execSQL("UPDATE 'Badges' SET 'Progress' = " + newProgress + " WHERE 'BadgeName' = " + "'" + badgeName + "'");
    }
    /*
    public void saveQuestions(ArrayList<Question> savedQuestions){

        int type = questionObject.getQuestionType();
        String question = questionObject.getQuestionText();
        boolean correctAnswer = questionObject.getCorrectAnswer();


        for (int i = 0; i < savedQuestions.size(); i++){
            database.execSQL("INSERT INTO 'SavedQuestions'(" + type + question + correctAnswer +"");
        }


    }

*/
    public ArrayList<Question> receiveSavedQuestions(){
        ArrayList<Question> savedQuestionArrayList = new ArrayList<>();
        String[] columns = new String[]{"QuestionType", "QuestionText", "CorrectAnswer"};

        Cursor cursor = database.query("SavedQuestions", columns, null,
                null, null, null, null);


        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int iQType = cursor.getColumnIndex("QuestionType");
            int iQText = cursor.getColumnIndex("QuestionText");
            int iCorrectAns = cursor.getColumnIndex("CorrectAnswer");


            do {
                int type = cursor.getInt(iQType);
                String text = cursor.getString(iQText);
                int rawAnswer = cursor.getInt(iCorrectAns);
                boolean answer = (rawAnswer != 0);

                Question question = new Question(type, text, answer);
                savedQuestionArrayList.add(question);
            }
            while (cursor.moveToNext());

            cursor.close();
        }
        return savedQuestionArrayList;
    }
}

