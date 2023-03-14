package com.example.filemanager.model;

public class VideoThumb {
    private String nameItemThumb;

    public VideoThumb(String nameItemThumb) {
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
        return "VideoThumb{" +
                "nameItemThumb='" + nameItemThumb + '\'' +
                '}';
    }
}
