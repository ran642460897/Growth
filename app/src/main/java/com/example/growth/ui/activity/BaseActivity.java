package com.example.growth.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.growth.annotation.ViewInject;

import java.lang.reflect.Field;

/**
 * Creator:ran
 * Date:2016-02-01 16:27
 * Note:
 */
public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        injectView();
    }
    /**
     * View注射
     */
    private void injectView(){
        try {
            Class<?> A=getClass();
            for(Field field:A.getDeclaredFields()){
                if(field.isAnnotationPresent(ViewInject.class)){
                    ViewInject inject=field.getAnnotation(ViewInject.class);
                    field.setAccessible(true);
                    field.set(this,this.findViewById(inject.value()));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
