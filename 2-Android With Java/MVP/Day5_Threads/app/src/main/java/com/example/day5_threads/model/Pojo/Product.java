package com.example.day5_threads.model.Pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Product")
public class Product {
    @SerializedName("id")
    @PrimaryKey
    @NonNull
    private int id;
    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private double price;

    @SerializedName("rating")
    @ColumnInfo(name = "rate")
    private double rating;

    @SerializedName("thumbnail")
    private String thumbnail;


    public Product(int id, String title, String description, double price, double rating, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}