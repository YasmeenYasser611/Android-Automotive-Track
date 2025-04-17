package com.example.day5_threads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList)
    {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Product product = productList.get(position);

        holder.title.setText(product.getTitle());
        holder.description.setText(product.getDescription());
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.rating.setRating((float) product.getRating());
        holder.rating.setEnabled(false);

        // Load image with Glide, showing placeholder if offline
        RequestOptions requestOptions = new RequestOptions()
                .override(200, 200)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground);

        if (!NetworkUtil.isNetworkAvailable(context))
        {
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        }

        Glide.with(context)
                .load(product.getThumbnail())
                .apply(requestOptions)
                .into(holder.image);

        holder.constraintLayout.setOnClickListener(v -> {
            String message = product.getTitle();
            if (!NetworkUtil.isNetworkAvailable(context)) {
                message += " (offline)";
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount()
    {
        return productList != null ? productList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title, description, price;
        ImageView image;
        RatingBar rating;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tittle);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.imgv);
            rating = itemView.findViewById(R.id.ratingBar);
            constraintLayout = itemView.findViewById(R.id.rec);
        }
    }
}