package com.example.day5_threads.mainscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day5_threads.R;
import com.example.day5_threads.allproducts.view.AllProductsActivity;
import com.example.day5_threads.favproducts.view.FavoriteProductActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnMain = findViewById(R.id.Main);
        Button btnFav = findViewById(R.id.Fav);
        Button btnExit = findViewById(R.id.button3);

        btnMain.setOnClickListener(v -> {
            startActivity(new Intent(this, AllProductsActivity.class));
        });

        btnFav.setOnClickListener(v -> {
            startActivity(new Intent(this, FavoriteProductActivity.class));
        });

        btnExit.setOnClickListener(v -> {
            finish();
        });
    }
}


