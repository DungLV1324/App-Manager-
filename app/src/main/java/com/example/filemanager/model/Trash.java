package com.example.filemanager.model;

public class Trash {
    private String nameImage;
    private  String dateImage;

    public Trash(String nameImage, String dateImage) {
        this.nameImage = nameImage;
        this.dateImage = dateImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getDateImage() {
        return dateImage;
    }

    public void setDateImage(String dateImage) {
        this.dateImage = dateImage;
    }

    @Override
    public String toString() {
        return "Trash{" +
                "nameImage='" + nameImage + '\'' +
                ", dateImage='" + dateImage + '\'' +
                '}';
    }
}
