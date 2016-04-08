package com.example.growth.modules.gl;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Creator:ran
 * Date:2016-02-02 08:59
 * Note:
 */
public class MyRenderer implements GLSurfaceView.Renderer {
    static int one=0x10000;
    private IntBuffer triBuffer;
    private IntBuffer quaBuffer;
    private IntBuffer color1Buffer;
    private IntBuffer color2Buffer;

    private int[] tri=new int[]{
            0,one,0,
            -one,-one,0,
            one,-one,0
    };
    private int[] qua=new int[]{
            one,one,0,
            -one,one,0,
            one,-one,0,
            -one,-one,0
    };
    private int[] color1=new int[]{
            one,0,0,one,
            0,one,0,one,
            0,0,one,one
    };
    private int[] color2=new int[]{
            one,0,0,0,
            one,one,0,0,
            one,one,one,0,
            0,one,one,0
    };
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl10.glClearColor(0, 0, 0, 0);
        gl10.glShadeModel(GL10.GL_SMOOTH);
        gl10.glClearDepthf(1.0f);
        gl10.glEnable(GL10.GL_DEPTH_TEST);
        gl10.glDepthFunc(GL10.GL_LEQUAL);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        float ratio=(float)i/i1;
        gl10.glViewport(0, 0, i, i1);
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        gl10.glLoadIdentity();
        gl10.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        initBuffer();
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl10.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //绘制三角形
        gl10.glLoadIdentity();
        gl10.glTranslatef(-1.5f, 0.0f, -6.0f);
        gl10.glVertexPointer(3, GL10.GL_FIXED, 0, triBuffer);
        gl10.glColorPointer(4, GL10.GL_FIXED, 0, color1Buffer);
        gl10.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
        //绘制四边行
        gl10.glLoadIdentity();
        gl10.glTranslatef(1.5f, 0.0f, -6.0f);
        gl10.glVertexPointer(3, GL10.GL_FIXED, 0, quaBuffer);
        gl10.glColorPointer(4, GL10.GL_FIXED, 0, color2Buffer);
        gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        gl10.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl10.glDisableClientState(GL10.GL_COLOR_ARRAY);

    }

    /**
     * 初始化buffer对象
     */
    private void initBuffer(){
        ByteBuffer byteBuffer1=ByteBuffer.allocateDirect(tri.length*4);
        byteBuffer1.order(ByteOrder.nativeOrder());
        triBuffer=byteBuffer1.asIntBuffer();
        triBuffer.put(tri);
        triBuffer.position(0);

        ByteBuffer byteBuffer2=ByteBuffer.allocateDirect(qua.length*4);
        byteBuffer2.order(ByteOrder.nativeOrder());
        quaBuffer=byteBuffer2.asIntBuffer();
        quaBuffer.put(qua);
        quaBuffer.position(0);

        ByteBuffer byteBuffer3=ByteBuffer.allocateDirect(color1.length*4);
        byteBuffer3.order(ByteOrder.nativeOrder());
        color1Buffer=byteBuffer3.asIntBuffer();
        color1Buffer.put(color1);
        color1Buffer.position(0);

        ByteBuffer byteBuffer4=ByteBuffer.allocateDirect(color2.length*4);
        byteBuffer4.order(ByteOrder.nativeOrder());
        color2Buffer=byteBuffer4.asIntBuffer();
        color2Buffer.put(color2);
        color2Buffer.position(0);
    }
}
