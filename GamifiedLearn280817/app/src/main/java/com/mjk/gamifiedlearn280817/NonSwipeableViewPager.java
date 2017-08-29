package com.mjk.gamifiedlearn280817;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by Matthew Kennedy on 28/08/2017.
 */

public class NonSwipeableViewPager extends ViewPager {
    public NonSwipeableViewPager(Context context) {super(context);}

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {super(context, attrs);}

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {return false;}

    @Override
    public boolean onTouchEvent(MotionEvent ev) {return false;}

}