package com.example.lab2_counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private int rotationCounter = 0;
    private TextView tvCounter;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.textView);
        btnReset = findViewById(R.id.button);

        if (savedInstanceState != null)
        {
            rotationCounter = savedInstanceState.getInt("counter_key", 0);
        }

        //tvCounter.setText("Rotations: " + rotationCounter);

        btnReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                rotationCounter = 0;
                tvCounter.setText("Rotations: " + rotationCounter);
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter_key", rotationCounter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvCounter.setText("Rotations: " + ++rotationCounter);
    }
}
