package com.example.filemanager.model;

public class ZipThumb {
    private String nameItemThumb;

    public ZipThumb(String nameItemThumb) {
        this.nameItemThumb = nameItemThumb;
    }

    public String getNameItemThumb() {
        return nameItemThumb;
    }

    public void setNameItemThumb(String nameItemThumb) {
        this.nameItemThumb = nameItemThumb;
    }

    @Override
    public String toString() {
        return "ZipThumb{" +
                "nameItemThumb='" + nameItemThumb + '\'' +
                '}';
    }
}
