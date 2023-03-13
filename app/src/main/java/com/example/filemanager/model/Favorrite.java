package com.example.filemanager.model;

public class Favorrite {
    private String nameItemFavorite;

    public Favorrite(String nameItemFavorite) {
        this.nameItemFavorite = nameItemFavorite;
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
