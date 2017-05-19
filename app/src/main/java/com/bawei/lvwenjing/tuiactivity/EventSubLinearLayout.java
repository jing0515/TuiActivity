package com.bawei.lvwenjing.tuiactivity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by muhanxi on 17/5/13.
 */

public class EventSubLinearLayout extends LinearLayout {
    public EventSubLinearLayout(Context context) {
        super(context);
    }

    public EventSubLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventSubLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("EventSubLinearLayout dispatchTouchEvent ev = " + ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        System.out.println("EventSubLinearLayout onInterceptHoverEvent ev = " + event);
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("EventSubLinearLayout onTouchEvent ev = " + event);
        return super.onTouchEvent(event);
    }
}
