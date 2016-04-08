package com.example.growth.modules.spinner;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.growth.R;
import com.example.growth.annotation.ViewInject;
import com.example.growth.modules.main.BaseActivity;

/**
 * Creator:ran
 * Date:2016-02-03 16:19
 * Note:
 */
public class SpinnerActivity extends BaseActivity {
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
