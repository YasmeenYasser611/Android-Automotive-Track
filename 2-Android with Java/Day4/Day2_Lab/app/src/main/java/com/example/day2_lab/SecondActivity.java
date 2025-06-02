package com.example.day2_lab;

import static com.example.day2_lab.R.id.btnBack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private Button btnBack;
    private Button btn_Wsh;
    private Button btn_Rsh;
    private Button btn_WIS;
    private Button btn_RIS;

    private Button btn_RDB;

    private Button btn_WDB;

    private TextView txtphone;

    private TextView txtmsg;

    private static  final String PREF_FILE="MY_FILE";

    private static  final String MOBILE_NUMBER="01097734891";

    private static  final String MESSAGE="HI YASMEEN";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        btnBack=findViewById(R.id.btnBack);

        btn_WIS=findViewById(R.id.btn_WIS);
        btn_RIS=findViewById(R.id.btn_RIE);


        btn_Wsh=findViewById(R.id.btn_Wsh);
        btn_Rsh=findViewById(R.id.btn_Rsh);


        btn_WDB=findViewById(R.id.btn_wDB);
        btn_RDB=findViewById(R.id.btn_RDB);



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

        btn_Wsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre =  getSharedPreferences(SecondActivity.PREF_FILE , Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pre.edit();
                edit.putString(SecondActivity.MOBILE_NUMBER , txtphone.getText().toString());
                edit.putString(SecondActivity.MESSAGE , txtmsg.getText().toString());

                edit.commit();
               txtphone.setText("");
                txtmsg.setText("");



            }
        });

        btn_Rsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedPreferences pre =  getSharedPreferences(SecondActivity.PREF_FILE , Context.MODE_PRIVATE);
                txtphone.setText(pre.getString(SecondActivity.MOBILE_NUMBER, getString(R.string.n_a)));
                txtmsg.setText(pre.getString(SecondActivity.MOBILE_NUMBER , getString(R.string.n_a)));

            }
        });

        btn_WIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    FileOutputStream fos = openFileOutput(SecondActivity.PREF_FILE , Context.MODE_PRIVATE );
                    DataOutputStream dos = new DataOutputStream(fos);
                    dos.writeUTF( txtphone.getText().toString());
                    dos.writeUTF( txtmsg.getText().toString());

                    txtphone.setText("");
                    txtmsg.setText("");
                    dos.close();
                    fos.close();


                }
                catch (FileNotFoundException e)
                {
                    Toast.makeText(SecondActivity.this, "error in file", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    Toast.makeText(SecondActivity.this, "error in file", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btn_RIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    FileInputStream fis = openFileInput(SecondActivity.PREF_FILE  );
                    DataInputStream dis =  new DataInputStream(fis);
                    txtphone.setText(dis.readUTF());
                    txtmsg.setText(dis.readUTF());

                }
                catch (FileNotFoundException e)
                {
                    Toast.makeText(SecondActivity.this, "error in file", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(SecondActivity.this, "error in file", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_WDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageAdaptor adaptor = new MessageAdaptor(SecondActivity.this );
                long id = adaptor.insertMessage(new Message(txtphone.getText().toString() , txtmsg.getText().toString()));
                txtmsg.setText("");
            }
        });

        btn_RDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MessageAdaptor adaptor = new MessageAdaptor(SecondActivity.this);
                Message msg = adaptor.findMessage(txtphone.getText().toString());
                txtmsg.setText(msg.Message);

            }
        });



    }
}