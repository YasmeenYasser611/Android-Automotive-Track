package com.example.day6_rv;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Cake[] cakes =
                {
                        new Cake("Cake1" , "Cake1" ,R.drawable.one ),
                        new Cake("Cake2" , "Cake2" ,R.drawable.teo ),
                        new Cake("Cake3" , "Cake3" ,R.drawable.three ),
                        new Cake("Cake4" , "Cake4" ,R.drawable.four ),
                        new Cake("Cake5" , "Cake5" ,R.drawable.five ),
                        new Cake("Cake6" , "Cake6" ,R.drawable.six ),
                        new Cake("Cake7" , "Cake7" ,R.drawable.seven ),
                        new Cake("Cake8" , "Cake8" ,R.drawable.eight ),


                };

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        CakeAdapter adapter = new CakeAdapter(this , cakes);

        //ListView listview = findViewById(R.id.listv);

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        CakeAdapter adapter = new CakeAdapter(this , cakes);
        recyclerView.setAdapter(adapter);

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                Toast.makeText(MainActivity.this, adapter.getItem(position).getTittle(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }
}