package com.example.filemanager.model;

public class ImageThumb {
    private String nameImageThumb;

    public ImageThumb(String nameImageThumb) {
        this.nameImageThumb = nameImageThumb;
    }

    public String getNameImageThumb() {
        return nameImageThumb;
    }

    public void setNameImageThumb(String nameImageThumb) {
        this.nameImageThumb = nameImageThumb;
    }

    @Override
    public String toString() {
        return "ImageThumb{" +
                "nameImageThumb='" + nameImageThumb + '\'' +
                '}';
    }
}
