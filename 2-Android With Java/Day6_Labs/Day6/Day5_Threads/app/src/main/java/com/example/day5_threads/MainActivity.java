package com.example.day5_threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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




    ImageView img ;

    Handler handler ;

    private List<Product> productList = new ArrayList<>();

    RecyclerView recyclerView;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        ProductAdapter adapter = new ProductAdapter(this , productList);
        recyclerView.setAdapter(adapter);

        handler = new Handler(Looper.myLooper())
        {
            @Override
            public void handleMessage(@NonNull Message msg)
            {
                super.handleMessage(msg);

                adapter.notifyDataSetChanged();



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




}