package com.bawei.lvwenjing.tuiactivity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by muhanxi on 17/5/13.
 */

public class EventLinearLayout extends LinearLayout {
    public EventLinearLayout(Context context) {
        super(context);
    }

    public EventLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("EventLinearLayout dispatchTouchEvent ev = " + ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("EventLinearLayout onInterceptHoverEvent ev = " + ev);
        return super.onInterceptTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("EventLinearLayout onTouchEvent ev = " + event);
        return super.onTouchEvent(event);
    }
}
