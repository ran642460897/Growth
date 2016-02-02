package com.example.growth.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.growth.R;
import com.example.growth.annotation.ViewInject;
import com.example.growth.jni.Test;

/**
 * Creator:ran
 * Date:2016-02-01 16:27
 * Note:
 */
public class JniActivity extends BaseActivity{
    @ViewInject(R.id.jni_text)
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);
        initView();
    }

    public void initView(){
        Test test=new Test();
        textView.setText(test.print());
    }
}
