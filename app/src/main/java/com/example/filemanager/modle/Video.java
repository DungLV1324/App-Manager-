package com.example.filemanager.modle;

public class Video {
    private String nameVideo;

    public Video(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    @Override
    public String toString() {
        return "Video{" +
                "nameVideo='" + nameVideo + '\'' +
                '}';
    }
}
