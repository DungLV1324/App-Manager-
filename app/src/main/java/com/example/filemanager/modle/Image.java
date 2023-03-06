package com.example.filemanager.modle;

public class Image {

    private String nameImage;

    public Image(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    @Override
    public String toString() {
        return "Image{" +
                "nameImage='" + nameImage + '\'' +
                '}';
    }
}
