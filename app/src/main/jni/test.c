#include <jni.h>



JNIEXPORT jstring JNICALL
Java_com_example_growth_jni_Test_print(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "Hello JNI");
}