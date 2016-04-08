package com.example.growth.modules.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.growth.R;
import com.example.growth.modules.curl.CurlActivity;
import com.example.growth.modules.event.EventActivity;
import com.example.growth.modules.gl.OpenGLActivity;
import com.example.growth.modules.jni.JniActivity;
import com.example.growth.modules.smack.SmackActivity;
import com.example.growth.modules.spinner.SpinnerActivity;


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
        TextView spinner=(TextView)findViewById(R.id.main_spinner);
        TextView smack=(TextView)findViewById(R.id.main_smack);
        TextView event=(TextView)findViewById(R.id.main_event);
        jni.setOnClickListener(this);
        openGL.setOnClickListener(this);
        curl.setOnClickListener(this);
        spinner.setOnClickListener(this);
        smack.setOnClickListener(this);
        event.setOnClickListener(this);
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
            case R.id.main_spinner:
                i=new Intent(this,SpinnerActivity.class);
                startActivity(i);
                break;
            case R.id.main_smack:
                i=new Intent(this,SmackActivity.class);
                startActivity(i);
                break;
            case R.id.main_event:
                i=new Intent(this,EventActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
