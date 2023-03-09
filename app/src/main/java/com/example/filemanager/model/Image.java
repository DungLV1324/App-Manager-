package com.example.filemanager.model;

public class Image {

    private String nameImage;
    private  String dateImage;

    public Image(String nameImage, String dateImage) {
        this.nameImage = nameImage;
        this.dateImage = dateImage;
    }

    public String getDateImage() {
        return dateImage;
    }

    public void setDateImage(String dateImage) {
        this.dateImage = dateImage;
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
                ", date='" + dateImage + '\'' +
                '}';
    }
}
