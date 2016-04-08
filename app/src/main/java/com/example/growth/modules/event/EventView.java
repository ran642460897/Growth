package com.example.growth.modules.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Creator:ran
 * Date:2016-04-06 10:21
 * Note:
 */
public class EventView extends TextView {
    public static String I="Touch event";
    public EventView(Context context){
        super(context);
    }
    public EventView(Context context,AttributeSet attrs){
        super(context,attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(I, "View dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(I, "View onTouchEvent");
        return super.onTouchEvent(event);
    }
}
