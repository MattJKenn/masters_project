package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mjk.gamifiedlearn280817.Badge;
import com.mjk.gamifiedlearn280817.R;

/**
 * Created by owner on 13/11/2017.
 */

public class BadgeViewAdapter extends BaseAdapter {

    int badge[];

    String title[];

    ProgressBar progress[];

    private Context context;

    private LayoutInflater layoutInflater;

    public BadgeViewAdapter(int badge[], String title[], Context context){
        this.badge = badge;
        this.title = title;
        this.context = context;
    }

    @Override
    public int getCount() {return badge.length;}

    @Override
    public Object getItem(int position) {return badge[position];}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View badgeView = convertView;

        if (convertView == null){
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert layoutInflater != null;
            badgeView = layoutInflater.inflate(R.layout.fragment_profile, parent, false);
        }

        ImageButton badge = (ImageButton) badgeView.findViewById(R.id.badges);
        TextView title = (TextView) badgeView.findViewById(R.id.badge_text);
        //ProgressBar progress = (ProgressBar) badgeView.findViewById(R.id.progress);


        badge.setImageResource(position);
        title.setText(position);
        //progress.setProgress(0);

        return null;
    }

}