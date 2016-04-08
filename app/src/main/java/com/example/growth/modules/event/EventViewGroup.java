package com.example.growth.modules.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Creator:ran
 * Date:2016-04-06 10:16
 * Note:
 */
public class EventViewGroup extends FrameLayout {
    public static String I="Touch event";
    public EventViewGroup(Context context){
        super(context);
    }
    public EventViewGroup(Context context,@Nullable AttributeSet attrs){
        super(context, attrs,0);
    }
    public EventViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(I,"ViewGroup dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(I,"ViewGroup onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(I,"ViewGroup onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }
}
