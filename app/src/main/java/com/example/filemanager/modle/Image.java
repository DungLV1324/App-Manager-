package com.example.filemanager.modle;

public class Image {

    private String nameImage;
    private  String dateImage;

    public String getDate() {
        return dateImage;
    }

    public void setDate(String date) {
        this.dateImage = date;
    }

    public Image(String nameImage, String date) {
        this.nameImage = nameImage;
        this.dateImage = date;
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
