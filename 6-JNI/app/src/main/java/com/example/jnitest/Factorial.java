package com.example.jnitest;

import android.util.Log;

public class Factorial {


    private long result ;

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public void factorial(int n)
    {


        Log.i("TAG", "Java" + n);
        CalcFact(n);
        Log.i("TAG", "Java" + result);

    }

    public  native void  CalcFact(int n);

}
