package com.mjk.gamifiedlearn280817;



import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



/**
 * A simple {@link Fragment} subclass.
 */
public class SavedQFragment extends Fragment {


    public SavedQFragment() {}



    //ArrayList<Question> savedQuestions = new ArrayList<>();
    //List<String> questionList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View savedQView = inflater.inflate(R.layout.fragment_saved_q, container, false);


        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(getContext());
        SQLiteDatabase database = databaseOpenHelper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT _id, QuestionText FROM SavedQuestions", null);

        ListView savedQs = (ListView) savedQView.findViewById(R.id.savedq_list);

        SavedQViewAdapter savedQViewAdapter = new SavedQViewAdapter(getContext(), cursor, 0);

        savedQs.setAdapter(savedQViewAdapter);

        cursor.close();

        return savedQView;
    }
/*
    public void getSavedQuestions(){
        databaseAccess = new DatabaseAccess(getContext());
        databaseAccess.open();
        savedQuestions = databaseAccess.receiveSavedQuestions();
        databaseAccess.close();
    }

    public List<String> setSavedQuestions() {

        if (savedQuestions.size() > 0) {
            for (int i = 0; i < savedQuestions.size(); i++) {
                Question selectedQ = savedQuestions.get(i);
                String question = selectedQ.getQuestionText();
                questionList.add(i, question);
            }
        }
        else {
            String emptyMessage = "Questions You Answer Incorrectly Will Appear Here";
            questionList.add(0, emptyMessage);
        }
        return questionList;
    }
*/
}
