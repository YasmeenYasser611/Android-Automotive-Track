package com.example.day5_threads.mainscreen.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day5_threads.R;
import com.example.day5_threads.allproducts.controller.MainMenuActivity;
import com.example.day5_threads.favproducts.controller.FavActivity;

// MainMenuActivity.java (for your menu with Main/Fav/Exit buttons)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnMain = findViewById(R.id.Main);
        Button btnFav = findViewById(R.id.Fav);
        Button btnExit = findViewById(R.id.button3);

        btnMain.setOnClickListener(v -> {
            startActivity(new Intent(this, MainMenuActivity.class));
        });

        btnFav.setOnClickListener(v -> {
            startActivity(new Intent(this, FavActivity.class));
        });

        btnExit.setOnClickListener(v -> {
            finish();
        });
    }
}


