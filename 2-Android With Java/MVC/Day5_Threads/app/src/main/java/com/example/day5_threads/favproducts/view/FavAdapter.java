package com.example.day5_threads.favproducts.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day5_threads.R;
import com.example.day5_threads.allproducts.view.ProductAdapter;
import com.example.day5_threads.model.Pojo.Product;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    private Context context;
    private List<Product> favoriteList;
    private OnFavoriteRemoveClickListener listener;

    public FavAdapter(Context context, List<Product> favoriteList, OnFavoriteRemoveClickListener listener) {
        this.context = context;
        this.favoriteList = favoriteList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fav, parent, false); // Reuse the same layout
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Product product = favoriteList.get(position);

        holder.title.setText(product.getTitle());
        holder.description.setText(product.getDescription());
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.rating.setRating((float) product.getRating());
        holder.rating.setEnabled(false);


        Glide.with(context)
                .load(product.getThumbnail())
                .apply(new RequestOptions()
                        .override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.image);

//        holder.constraintLayout.setOnClickListener(v -> {
//            Toast.makeText(context, product.getTitle(), Toast.LENGTH_SHORT).show();
//        });

        holder.removeBtn.setOnClickListener(v -> {
            listener.onFavRemoveProductClick(product);
        });
    }

    @Override
    public int getItemCount() {
        return favoriteList != null ? favoriteList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title, description, price;
        ImageView image;
        RatingBar rating;
        ConstraintLayout constraintLayout;

        Button removeBtn ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tittle);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.imgv);
            rating = itemView.findViewById(R.id.ratingBar);
            constraintLayout = itemView.findViewById(R.id.rec);
            removeBtn =  itemView.findViewById(R.id.Del);
        }
    }
}