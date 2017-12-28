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

    private static final String QUESTION_BANK_TABLE_NAME = "QuestionBank";
    private static final String SAVED_QUESTION_TABLE_NAME = "SavedQuestions";
    private static final String BADGES_TABLE_NAME = "Badges";

    private static final String QUESTION_TYPE_COLUMN_NAME = "QuestionType";
    private static final String QUESTION_TEXT_COLUMN_NAME = "QuestionText";
    private static final String CORRECT_ANSWER_COLUMN_NAME = "CorrectAnswer";
    private static final String BADGE_NAME_COLUMN_NAME = "BadgeName";
    private static final String BRONZE_UNLOCK_COLUMN_NAME = "BronzeUnlock";
    private static final String SILVER_UNLOCK_COLUMN_NAME = "SilverUnlock";
    private static final String GOLD_UNLOCK_COLUMN_NAME = "GoldUnlock";
    private static final String PROGRESS_COLUMN_NAME = "Progress";

    //int progress;

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
        String[] columns = new String[]{QUESTION_TYPE_COLUMN_NAME, QUESTION_TEXT_COLUMN_NAME, CORRECT_ANSWER_COLUMN_NAME};

        Cursor cursor = database.query(QUESTION_BANK_TABLE_NAME, columns, QUESTION_TYPE_COLUMN_NAME + " = " + qType,
                null, null, null, null);


        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int iQType = cursor.getColumnIndex(QUESTION_TEXT_COLUMN_NAME);
            int iQText = cursor.getColumnIndex(QUESTION_TEXT_COLUMN_NAME);
            int iCorrectAns = cursor.getColumnIndex(CORRECT_ANSWER_COLUMN_NAME);


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
        String[] columns = new String[]{BADGE_NAME_COLUMN_NAME, BRONZE_UNLOCK_COLUMN_NAME,
                                        SILVER_UNLOCK_COLUMN_NAME, GOLD_UNLOCK_COLUMN_NAME, PROGRESS_COLUMN_NAME};

        Cursor cursor = database.query(BADGES_TABLE_NAME, columns, null,
                null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int iName = cursor.getColumnIndex(BADGES_TABLE_NAME);
            int iBronze = cursor.getColumnIndex(BRONZE_UNLOCK_COLUMN_NAME);
            int iSilver = cursor.getColumnIndex(SILVER_UNLOCK_COLUMN_NAME);
            int iGold = cursor.getColumnIndex(GOLD_UNLOCK_COLUMN_NAME);
            int iProg = cursor.getColumnIndex(PROGRESS_COLUMN_NAME);

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
        database.execSQL("UPDATE " + BADGES_TABLE_NAME + " SET " + PROGRESS_COLUMN_NAME + " = "
                        + newProgress + " WHERE " + BADGE_NAME_COLUMN_NAME + " = " + badgeName);
    }


    public void saveQuestions(ArrayList<Question> savedQuestions) {

        int type = questionObject.getQuestionType();
        String question = questionObject.getQuestionText();
        boolean correctAnswer = questionObject.getCorrectAnswer();


        for ( int i = 0; i < savedQuestions.size(); i++ ) {
            database.execSQL("INSERT INTO " + SAVED_QUESTION_TABLE_NAME + "(" + type + question + correctAnswer + ")");
        }


    }



    public ArrayList<Question> receiveSavedQuestions(){
        ArrayList<Question> savedQuestionArrayList = new ArrayList<>();
        String[] columns = new String[]{QUESTION_TYPE_COLUMN_NAME, QUESTION_TEXT_COLUMN_NAME, CORRECT_ANSWER_COLUMN_NAME};

        Cursor cursor = database.query(SAVED_QUESTION_TABLE_NAME, columns, null,
                null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int iQType = cursor.getColumnIndex(QUESTION_TYPE_COLUMN_NAME);
            int iQText = cursor.getColumnIndex(QUESTION_TEXT_COLUMN_NAME);
            int iCorrectAns = cursor.getColumnIndex(CORRECT_ANSWER_COLUMN_NAME);


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

    public ArrayList<String> getQuestionTextList(){

        ArrayList<Question> fullQuestionArrayList = receiveSavedQuestions();
        ArrayList<String> savedQuestionTextList = new ArrayList<>();

        int QuestionListLength = fullQuestionArrayList.size();

        for (int i = 0; i < QuestionListLength; i++){
            String questionText = questionObject.getQuestionText();
            savedQuestionTextList.add(questionText);
        }

        return savedQuestionTextList;
    }
}
