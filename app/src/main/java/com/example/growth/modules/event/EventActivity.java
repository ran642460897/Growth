package com.example.growth.modules.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.growth.R;

/**
 * Creator:ran
 * Date:2016-04-06 10:12
 * Note:
 */
public class EventActivity extends Activity {
    public static String I="Touch event";
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(I,"Activity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(I,"Activity onTouchEvent");
        return super.onTouchEvent(event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }
}
