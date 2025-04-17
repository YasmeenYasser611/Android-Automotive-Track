package com.example.day6_rv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.viewHandler>
{
    Context context;
    Cake[] cakes ;

    public CakeAdapter(Context _context ,Cake[] data )
    {

        context = _context;
        cakes = data;


    }

    @NonNull
    @Override
    public CakeAdapter.viewHandler onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.cakerow , recyclerView , false);
        viewHandler vh = new viewHandler(v);
//        Log.i(TAG, "onCreateViewHolder: ");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CakeAdapter.viewHandler holder, int position) {

        holder.img.setImageResource(cakes[position].getThumbnail());
        holder.tittle.setText(cakes[position].getTittle());
        holder.desc.setText(cakes[position].getDescription());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, cakes[position].getTittle().toString(), Toast.LENGTH_SHORT).show();
            }
        });





    }

    @Override
    public int getItemCount() {
        return cakes.length;
    }

    public class viewHandler extends RecyclerView.ViewHolder
    {
        TextView tittle;
        TextView desc ;
        View row ;
        ImageView img ;

        ConstraintLayout constraintLayout ;
        public viewHandler(View v)
        {
            super(v);
            row = v ;
            tittle = v.findViewById(R.id.tittle);
            desc = v.findViewById(R.id.desc);
            img = v.findViewById(R.id.imgv);
            constraintLayout = v.findViewById(R.id.main);


        }
    }
//    Context context;
//    Cake[] cakes ;
//
//    public CakeAdapter(Context _context ,Cake[] data )
//    {
//        super(_context ,R.layout.cakerow , R.id.tittle  , data );
//        context = _context;
//        cakes = data;
//
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup lstview)
//    {
//        View row = null ;
//
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        row = inflater.inflate(R.layout.cakerow , lstview , false);
//        ImageView img = row.findViewById(R.id.imgv);
//        TextView tittle = row.findViewById(R.id.tittle);
//        TextView desc = row.findViewById(R.id.desc);
//        img.setImageResource(cakes[position].getThumbnail());
//        tittle.setText(cakes[position].getTittle());
//        desc.setText(cakes[position].getDescription());
//
//
//        return  row;
//
//    }
}
