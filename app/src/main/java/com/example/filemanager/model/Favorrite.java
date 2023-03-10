package com.example.filemanager.model;

public class Favorrite {
    private String nameItemFavorite;

    private String dateItemFavorite;

    public Favorrite(String nameItemFavorite, String dateItemFavorite) {
        this.nameItemFavorite = nameItemFavorite;
        this.dateItemFavorite = dateItemFavorite;
    }

    public String getDateItemFavorite() {
        return dateItemFavorite;
    }
    public String getNameItemFavorite() {
        return nameItemFavorite;
    }

    public void setNameItemFavorite(String nameItemFavorite) {
        this.nameItemFavorite = nameItemFavorite;
    }

    @Override
    public String toString() {
        return "Favorrite{" +
                "nameItemFavorite='" + nameItemFavorite + '\'' +
                '}';
    }
}
