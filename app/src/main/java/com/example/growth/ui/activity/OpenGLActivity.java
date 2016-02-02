package com.example.growth.ui.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.example.growth.renderer.MyRenderer;

/**
 * Creator:ran
 * Date:2016-02-01 16:36
 * Note:
 */
public class OpenGLActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLSurfaceView gf=new GLSurfaceView(this);
        MyRenderer renderer=new MyRenderer();
        gf.setRenderer(renderer);
        setContentView(gf);
    }
}
