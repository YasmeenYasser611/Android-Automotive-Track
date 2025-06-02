package com.example.day5_threads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHandler> {
    Context context;

    private List<Product> productList ;



    public ProductAdapter(Context _context, List<Product> data) {

        context = _context;
        productList = data;
    }

    @NonNull
    @Override
    public viewHandler onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType)
    {

        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.product, recyclerView, false);
        viewHandler vh = new viewHandler(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHandler holder, int position)
    {

        holder.tittle.setText(productList.get(position).getTitle());
        holder.desc.setText(productList.get(position).getDescription());

        double result = productList.get(position).getPrice() ;
        String finalresult = new Double(result).toString();
        holder.price.setText(finalresult);

        holder.rate.setRating((float) productList.get(position).getRating());

        new DownloadTask(holder.img).execute(productList.get(position).getThumbnail());


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Toast.makeText(context, productList.get(adapterPosition).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }




    public class viewHandler extends RecyclerView.ViewHolder
    {
        TextView tittle;
        TextView desc;

        TextView price;
        View row;
        ImageView img;
        RatingBar rate;

        ConstraintLayout constraintLayout;

        public viewHandler(View v)
        {
            super(v);
            row = v;

            tittle = v.findViewById(R.id.tittle);
            price = v.findViewById(R.id.price);
            desc = v.findViewById(R.id.description);

            rate = v.findViewById(R.id.ratingBar);
            img = v.findViewById(R.id.imgv);

            constraintLayout = v.findViewById(R.id.rec);


        }
    }

    class DownloadTask extends AsyncTask<String, Void, Bitmap>
    {

        private final ImageView imageView;

        public DownloadTask(ImageView imageView)
        {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap result = null;
            try
            {
                result = Download(strings[0]);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }

        private Bitmap Download(String url) throws IOException {
            URL imgurl = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) imgurl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK)
            {
                InputStream is = connection.getInputStream();
                return BitmapFactory.decodeStream(is);
            }
            else
            {
                return null;
            }
        }
    }


}
