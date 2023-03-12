package com.example.filemanager.data.model;

import com.example.filemanager.util.DateUtil;
import com.example.filemanager.util.StorageUtils;

public class ItemImage {

    private String nameFileImage;
    private String nameTitleImage;
    private String nameFolder;
    private long size;
    private String path;
    private String imageId;
    private long timeModified;
    private long timeAdded;

    public ItemImage() {
    }

    public String getNameFileImage() {
        return nameFileImage;
    }

    public void setNameFileImage(String nameFileImage) {
        this.nameFileImage = nameFileImage;
    }

    public String getNameTitleImage() {
        return nameTitleImage;
    }

    public void setNameTitleImage(String nameTitleImage) {
        this.nameTitleImage = nameTitleImage;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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


    public ItemImage cloneValue() {
        ItemImage itemImage = new ItemImage();
        itemImage.setNameFileImage(nameFileImage);
        itemImage.setNameTitleImage(nameTitleImage);
        itemImage.setNameFolder(nameFolder);
        itemImage.setSize(size);
        itemImage.setPath(path);
        itemImage.setImageId(imageId);
        itemImage.setTimeModified(timeModified);
        itemImage.setTimeAdded(timeAdded);
        return itemImage;
    }

    @Override
    public String toString() {
        return "ItemImage{" +
                "\n- nameFileImage='" + nameFileImage + '\'' +
                "\n- nameTitleImage='" + nameTitleImage + '\'' +
                "\n- nameFolder='" + nameFolder + '\'' +
                "\n- size=" + size + "--to string: " + StorageUtils.readableFileSize(size) +
                "\n- path='" + path + '\'' +
                "\n- ImageId='" + imageId + '\'' +
                "\n- timeModified=" + timeModified + "--to Date: " + DateUtil.formatTime(timeModified, "hh:ss, dd/MM/yyyy") +
                "\n- timeAdded=" + timeAdded + "--to Date: " + DateUtil.formatTime(timeAdded, "hh:ss, dd/MM/yyyy") +
                '}' + "\n--------------------";
    }
}
