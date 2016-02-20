package com.example.growth.ui.activity;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.growth.R;
import com.example.growth.annotation.ViewInject;

/**
 * Creator:ran
 * Date:2016-02-03 16:19
 * Note:
 */
public class SpinnerActivity extends BaseActivity{
    @ViewInject(R.id.spinner)
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initView();
    }
    private void initView(){
        spinner.setDropDownVerticalOffset(100);
        spinner.setSelection(1);
    }
}
