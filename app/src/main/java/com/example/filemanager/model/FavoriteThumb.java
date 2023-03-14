package com.example.filemanager.model;

public class FavoriteThumb {
    private String nameItemFavorite;

    public FavoriteThumb(String nameItemFavorite) {
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
        return "FavoriteThumb{" +
                "nameItemFavorite='" + nameItemFavorite + '\'' +
                '}';
    }
}
