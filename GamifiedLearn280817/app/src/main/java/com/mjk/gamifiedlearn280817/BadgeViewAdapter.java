package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by owner on 13/11/2017.
 */

public class BadgeViewAdapter extends BaseAdapter {

    int badge[];


    String title[];


    int progress[];

    private Context context;

    private LayoutInflater layoutInflater;

    DatabaseAccess databaseAccess;

    ArrayList<Badge> badges = new ArrayList<>();

    Badge badgeObject;


    // Badge badge1, badge2, badgetotal;              // badge object variables

        /*
    int[] badge1Values = {0, 10, 25, 50};
    int[] badge2Values = {0, 10, 25, 50};
    int[] badgeTotalValues = {0, 25, 50, 100};
        */
    ImageView badgeGraphic;
    GridView badgeView;

    SharedPreferences badgeProgressPref;


    public BadgeViewAdapter(int badges[], String titles[], int progresses[], Context context) {
        this.badge = badges;
        this.title = titles;
        this.progress = progresses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return badge.length;
    }

    @Override
    public Object getItem(int position) {
        return badge[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View badgeView = convertView;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            badgeView = layoutInflater.inflate(R.layout.badge_view_adapter, parent, false);
        }

        // assign variables to layout assets
        ImageView badgeGraphic = (ImageView) badgeView.findViewById(R.id.badges);
        TextView titleText = (TextView) badgeView.findViewById(R.id.badge_text);
        TextView progress = (TextView) badgeView.findViewById(R.id.progress);

        receiveBadges();

        //BadgeLogic.updateBadgeRank();

        // set variable values



        badgeGraphic.setImageResource(badge[position]);
        titleText.setText(title[position]);
        progress.setText(this.progress.toString() + "/" + badgeObject.gold); // placeholder

        /*
        badge1 = new Badge("Quiz 1 Badge", bronze,
                silver, gold);
        badge2 = new Badge("Quiz 2 Badge", badge2Values,
                false, false, false);
        badgetotal = new Badge("Quiz Total Badge", badgeTotalValues,
                false, false, false);
        */
        //badgeProgressPref = getSharedPreferences("progress", MODE_PRIVATE)

        return badgeView;
    }


    public void receiveBadges(){
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        badges = databaseAccess.getBadges();
        databaseAccess.close();
    }

}



