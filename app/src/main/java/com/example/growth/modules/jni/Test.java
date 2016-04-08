package com.example.growth.modules.jni;

/**
 * Creator:ran
 * Date:2016-02-01 16:27
 * Note:
 */
public class Test {
    static {
        System.loadLibrary("test");
    }
    public native String print();
}
