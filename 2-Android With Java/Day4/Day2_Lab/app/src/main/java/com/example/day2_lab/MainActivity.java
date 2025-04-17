package com.example.day2_lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private static final String TAG="MainActivity" ;
    private Button btnNext;
    private Button btnExit;

    private EditText edtPhone;

    private EditText edtText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");

        //btnExit=findViewById(R.id.btnExit);
        btnNext = findViewById(R.id.btnNext);
        edtPhone = findViewById(R.id.edtPhone);

        edtText = findViewById(R.id.edtText);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                intent.putExtra("Mobile_Number" ,edtPhone.getText().toString() );
                intent.putExtra("Message" , edtText.getText().toString());
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    public void exit(View view) {
        finish();
    }
}