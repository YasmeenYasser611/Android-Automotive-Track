package com.example.day6_rv;
public class Cake {

    private  String tittle;

    private String description ;

    public Cake(String description, String tittle ,int thumbnail) {
        this.thumbnail = thumbnail;
        this.description = description;
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    private int thumbnail ;

}
