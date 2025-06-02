package com.example.lab3_fragmentslifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity" ;
    private FragmentManager mgr;
    private DynamicFragment dynamicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i(TAG, "Activity onCreate: ");

        mgr = getSupportFragmentManager();

        if(savedInstanceState == null)
        {
            dynamicFragment = new DynamicFragment();

        }
        else
        {
            //fragment is exist i only want reference on it
            dynamicFragment = (DynamicFragment) mgr.findFragmentByTag("Dynamic_Fragment");
        }

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    FragmentTransaction trans = mgr.beginTransaction();
                    trans.add(R.id.DynamicContainerView3, dynamicFragment, "Dynamic_Fragment");
                    trans.commit();


            }
        });

        Button btnRemove = findViewById(R.id.btnrmv);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                    FragmentTransaction trans = mgr.beginTransaction();
                    trans.remove(dynamicFragment);
                    trans.commit();


            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activity onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Activity onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity onDestroy: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Activity onSaveInstanceState: ");
    }
}