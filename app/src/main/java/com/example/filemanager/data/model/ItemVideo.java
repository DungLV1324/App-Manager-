package com.example.filemanager.data.model;

import com.example.filemanager.util.DateUtil;
import com.example.filemanager.util.FileMediaUtil;
import com.example.filemanager.util.StorageUtils;

public class ItemVideo {

    private String nameFileVideo;
    private String nameTitleVideo;
    private String nameFolder;
    private long size;
    private String path;
    private String videoId;
    private long timeModified;
    private long timeAdded;
    private long duration;

    public ItemVideo() {
    }

    public String getNameFileVideo() {
        return nameFileVideo;
    }

    public void setNameFileVideo(String nameFileVideo) {
        this.nameFileVideo = nameFileVideo;
    }

    public String getNameTitleVideo() {
        return nameTitleVideo;
    }

    public void setNameTitleVideo(String nameTitleVideo) {
        this.nameTitleVideo = nameTitleVideo;
    }

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public long getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(long timeModified) {
        this.timeModified = timeModified;
    }

    public long getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(long timeAdded) {
        this.timeAdded = timeAdded;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public ItemVideo cloneValue() {
        ItemVideo itemVideo = new ItemVideo();
        itemVideo.setNameFileVideo(nameFileVideo);
        itemVideo.setNameTitleVideo(nameTitleVideo);
        itemVideo.setNameFolder(nameFolder);
        itemVideo.setSize(size);
        itemVideo.setPath(path);
        itemVideo.setVideoId(videoId);
        itemVideo.setTimeModified(timeModified);
        itemVideo.setTimeAdded(timeAdded);
        itemVideo.setDuration(duration);
        return itemVideo;
    }

    @Override
    public String toString() {
        return "ItemVideo{" +
                "\n- nameFileVideo='" + nameFileVideo + '\'' +
                "\n- nameTitleVideo='" + nameTitleVideo + '\'' +
                "\n- nameFolder='" + nameFolder + '\'' +
                "\n- size=" + size + "--to string: " + StorageUtils.readableFileSize(size) +
                "\n- path='" + path + '\'' +
                "\n- videoId='" + videoId + '\'' +
                "\n- timeModified=" + timeModified + "--to Date: " + DateUtil.formatTime(timeModified, "hh:ss, dd/MM/yyyy") +
                "\n- timeAdded=" + timeAdded + "--to Date: " + DateUtil.formatTime(timeAdded, "hh:ss, dd/MM/yyyy") +
                "\n- duration=" + duration + "--to Date: " + FileMediaUtil.formatDuration(duration) +
                '}' + "\n--------------------";
    }
}
