package com.example.day2_lab;

import static com.example.day2_lab.R.id.btnBack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private Button btnBack;

    private TextView txtphone;

    private TextView txtmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        btnBack=findViewById(R.id.btnBack);

        txtphone = findViewById(R.id.txtphone);
        txtmsg = findViewById(R.id.txtmsg);

        Intent incomming = getIntent();
        String mobile = incomming.getStringExtra("Mobile_Number");
        txtphone.setText(mobile);
        String msg = incomming.getStringExtra("Message");
        txtmsg.setText(msg);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}