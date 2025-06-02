package com.example.day5_asynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    EditText URL;

    Button Download;

    ImageView img ;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Download = findViewById(R.id.button);
        URL =  findViewById(R.id.url);
        img = findViewById(R.id.imageView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Downloading image...");
        progressDialog.setCancelable(false);

        Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                DownloadTask Task = new DownloadTask();
                Task.execute(URL.getText().toString());
            }
        });



    }
        class DownloadTask extends AsyncTask<String , Void , Bitmap>
        {

            @Override
            protected Bitmap doInBackground(String... strings)
            {
                Bitmap result = null;
                try {
                    result = Download(strings[0]);
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Cannot Download Image", Toast.LENGTH_SHORT).show();
                }


                return result;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap)
            {
                super.onPostExecute(bitmap);
                img.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            private Bitmap Download (String url) throws IOException {
                URL imgurl = new URL(url);
                HttpsURLConnection connection = (HttpsURLConnection) imgurl.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if(responseCode == HttpsURLConnection .HTTP_OK)
                {
                    InputStream is = connection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    return bitmap ;
                }
                else
                {
                    return null;
                }
            }
        }


}