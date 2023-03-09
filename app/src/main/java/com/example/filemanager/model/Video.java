package com.example.filemanager.model;

public class Video {
    private String nameVideo;
    private String dateVideo;

    public Video(String nameVideo, String dateVideo) {
        this.nameVideo = nameVideo;
        this.dateVideo = dateVideo;
    }

    public String getDateVideo() {
        return dateVideo;
    }

    public void setDateVideo(String dateVideo) {
        this.dateVideo = dateVideo;
    }

    @Override
    public String toString() {
        return "Video{" +
                "nameVideo='" + nameVideo + '\'' +
                ", dateVideo='" + dateVideo + '\'' +
                '}';
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

}
