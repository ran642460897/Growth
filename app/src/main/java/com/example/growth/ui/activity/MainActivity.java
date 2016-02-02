package com.example.growth.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.growth.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        TextView jni=(TextView)findViewById(R.id.main_jni);
        TextView openGL=(TextView)findViewById(R.id.main_openGL);
        TextView curl=(TextView)findViewById(R.id.main_curl);
        jni.setOnClickListener(this);
        openGL.setOnClickListener(this);
        curl.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.main_jni:
                i=new Intent(this, JniActivity.class);
                startActivity(i);
                break;
            case R.id.main_openGL:
                i=new Intent(this,OpenGLActivity.class);
                startActivity(i);
                break;
            case R.id.main_curl:
                i=new Intent(this,CurlActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
