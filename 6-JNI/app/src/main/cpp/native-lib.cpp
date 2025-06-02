#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnitest_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT void JNICALL
Java_com_example_jnitest_Factorial_CalcFact(JNIEnv *env, jobject obj, jint n) {


    jclass clazz = env ->GetObjectClass(obj);
    jfieldID res = env ->GetFieldID(clazz , "result" ,"J" );

    jlong temp = 1;

    for (int i = 1; i <= n; ++i)
    {
        temp *= i;
        printf("%d" , temp);

    }


    env ->SetLongField(obj , res , temp);


}