package com.example.filemanager.model;

public class Music {
    private String nameMusic;
    private String dateMusic;

    public Music(String nameMusic, String dateMusic) {
        this.nameMusic = nameMusic;
        this.dateMusic = dateMusic;
    }

    @Override
    public String toString() {
        return "Music{" +
                "nameMusic='" + nameMusic + '\'' +
                ", dateMusic='" + dateMusic + '\'' +
                '}';
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getDateMusic() {
        return dateMusic;
    }

    public void setDateMusic(String dateMusic) {
        this.dateMusic = dateMusic;
    }
}
