package com.example.filemanager.modle;

public class Apk {
    private String nameImage;

    public Apk(String nameImage) {
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
        return "Apk{" +
                "nameImage='" + nameImage + '\'' +
                '}';
    }
}
