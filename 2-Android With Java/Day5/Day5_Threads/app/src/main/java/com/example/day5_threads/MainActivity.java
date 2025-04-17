package com.example.day5_threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    TextView tittle;

    TextView price ;
    TextView description;
    RatingBar rating;


    Button prev;

    Button nxt ;

    ImageView img ;

    Handler handler ;

    private List<Product> productList = new ArrayList<>();
    int currentProductIndex =0;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prev = findViewById(R.id.prev);
        nxt = findViewById(R.id.next);
        img = findViewById(R.id.imgv);

        tittle = findViewById(R.id.tittle);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        rating = findViewById(R.id.ratingBar);

        handler = new Handler(Looper.myLooper())
        {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                //do the ui update
                //download imade(url from pogo )
                updateProductUI();



            }
        };

        new Thread() {

            //connect to the API
            //streams
            //Parsing
            //convert json to pojo = dto
            //fill in the products array
            @Override
            public void run() {
                try
                {
                    String jsonStr = downloadList("https://dummyjson.com/products");

                }
                catch (IOException | JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();



        nxt.setOnClickListener(new View.OnClickListener() {
            //update ui array[i]
            @Override
            public void onClick(View v) {
                if (currentProductIndex < productList.size() - 1) {
                    currentProductIndex++;
                    updateProductUI();
                }

            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentProductIndex > 0) {
                    currentProductIndex--;
                    updateProductUI();
                }

            }
        });


    }

        private String downloadList(String url) throws IOException, JSONException {
            String response = null;
            URL imgurl = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) imgurl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpsURLConnection .HTTP_OK)
            {
                InputStream is = connection.getInputStream();
                response = convertStreamToString(is);
                parseJsonAndUpdateUI(response);


            }
            return response;

        }

        private String convertStreamToString(InputStream is)
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return sb.toString();
        }


    private void updateProductUI() {
        if (productList.isEmpty() || currentProductIndex >= productList.size()) return;

        Product currentProduct = productList.get(currentProductIndex);

        tittle.setText(currentProduct.getTitle());
        price.setText(String.format("$%.2f", currentProduct.getPrice()));
        description.setText(currentProduct.getDescription());
        rating.setRating((float) currentProduct.getRating());
        rating.setEnabled(false);


        new DownloadTask().execute(currentProduct.getThumbnail());
    }

    private void parseJsonAndUpdateUI(String jsonStr) throws JSONException {
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray productsArray = jsonObject.getJSONArray("products");

            for (int i = 0; i < productsArray.length(); i++) {
                JSONObject productObj = productsArray.getJSONObject(i);
                Product product = new Product();
                product.setId(productObj.getInt("id"));
                product.setTitle(productObj.getString("title"));
                product.setDescription(productObj.getString("description"));
                product.setPrice(productObj.getDouble("price"));
                product.setRating(productObj.getDouble("rating"));
                product.setThumbnail(productObj.getString("thumbnail"));
                productList.add(product);
            }

            handler.sendEmptyMessage(0);



        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
        }
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