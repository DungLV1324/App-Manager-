package com.example.filemanager.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.filemanager.data.model.ItemImage;
import com.example.filemanager.data.model.ItemVideo;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;

public class FileMediaUtil {


    @SuppressLint("DefaultLocale")
    public static String formatDuration(long duration) {
        long minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS);
        long seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.MILLISECONDS)
                - minutes * TimeUnit.SECONDS.convert(1, TimeUnit.MINUTES);

        return String.format("%02d:%02d", minutes, seconds);
    }

    public static List<ItemVideo> getFileVideoFromExternalStorage(Context context) {
        List<ItemVideo> listVideo = new LinkedList<>();
        String[] projection = new String[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            projection = new String[]{
                    MediaStore.Video.Media._ID,
                    MediaStore.Video.Media.DATE_MODIFIED,
                    MediaStore.Video.Media.DATE_ADDED,
                    MediaStore.Video.Media.DATA,
                    MediaStore.Video.Media.SIZE,
                    MediaStore.Video.Media.TITLE,
                    MediaStore.Video.Media.DISPLAY_NAME,
                    MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                    MediaStore.Video.Media.DURATION
            };
        } else {
            projection = new String[]{
                    MediaStore.Video.Media._ID,
                    MediaStore.Video.Media.DATE_MODIFIED,
                    MediaStore.Video.Media.DATE_ADDED,
                    MediaStore.Video.Media.DATA,
                    MediaStore.Video.Media.SIZE,
                    MediaStore.Video.Media.TITLE,
                    MediaStore.Video.Media.DISPLAY_NAME,
                    MediaStore.Video.Media.DURATION
            };
        }
        Cursor cursor = context.getContentResolver()
                .query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Video.Media.DATE_MODIFIED + " DESC");

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int columnPath = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA);
                if (columnPath > -1) {
                    String path = cursor.getString(columnPath);
                    if (path != null) {
                        File f = new File(path);
                        if (f.isFile() && !f.isHidden()) {
                            ItemVideo itemVideo = new ItemVideo();
                            itemVideo.setPath(path);
                            int columnNameTitleFile = cursor.getColumnIndex(MediaStore.Video.Media.TITLE);
                            if (columnNameTitleFile > -1) {
                                itemVideo.setNameTitleVideo(cursor.getString(columnNameTitleFile));
                            }
                            int columnName = cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME);
                            if (columnName > -1) {
                                itemVideo.setNameFileVideo(cursor.getString(columnName));
                            }

                            int columnSize = cursor.getColumnIndex(MediaStore.Video.Media.SIZE);
                            if (columnSize > -1) {
                                itemVideo.setSize(cursor.getLong(columnSize));
                            }
                            int columnDateModify = cursor.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED);
                            if (columnDateModify > -1) {
                                //DATE_MODIFIED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                itemVideo.setTimeModified(cursor.getLong(columnDateModify) * 1000);
                            }
                            int columnDateAdded = cursor.getColumnIndex(MediaStore.Video.Media.DATE_ADDED);
                            if (columnDateAdded > -1) {
                                //DATE_ADDED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                itemVideo.setTimeAdded(cursor.getLong(columnDateAdded) * 1000);
                            }

                            int columnId = cursor.getColumnIndex(MediaStore.Video.Media._ID);
                            if (columnId > -1) {
                                itemVideo.setVideoId(cursor.getString(columnId));
                            }

                            long d = 0;
                            try {
                                MediaMetadataRetriever retriever = new MediaMetadataRetriever();
                                //use one of overloaded setDataSource() functions to set your data source
                                retriever.setDataSource(context, Uri.fromFile(f));
                                String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                                d = Long.parseLong(time);
                                retriever.release();
                            } catch (Exception e) {
                                int columnDuration = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DURATION);
                                if (columnDuration > -1) {
                                    d = cursor.getLong(columnDuration);
                                }
                                e.printStackTrace();
                            }
                            itemVideo.setDuration(d);
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                                int columnFolderName = cursor.getColumnIndex(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
                                itemVideo.setNameFolder(cursor.getString(columnFolderName));
                            } else {
                                if (f.getParentFile() != null) {
                                    itemVideo.setNameFolder(f.getParentFile().getName());
                                }
                            }
                            Timber.e("tunglt: " + itemVideo.toString());
                            listVideo.add(itemVideo);
                        }
                    }
                }

            }
            cursor.close();
        }
        return listVideo;
    }

    public static List<ItemImage> getFileImageFromExternalStorage(Context context) {
        List<ItemImage> listVideo = new LinkedList<>();
        String[] projection = new String[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            projection = new String[]{
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Media.DATE_MODIFIED,
                    MediaStore.Images.Media.DATE_ADDED,
                    MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media.SIZE,
                    MediaStore.Images.Media.TITLE,
                    MediaStore.Images.Media.DISPLAY_NAME,
                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
        } else {
            projection = new String[]{
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Media.DATE_MODIFIED,
                    MediaStore.Images.Media.DATE_ADDED,
                    MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media.SIZE,
                    MediaStore.Images.Media.TITLE,
                    MediaStore.Images.Media.DISPLAY_NAME
            };
        }
        Cursor cursor = context.getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, MediaStore.Images.Media.DATE_MODIFIED + " DESC");

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int columnPath = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA);
                if (columnPath > -1) {
                    String path = cursor.getString(columnPath);
                    if (path != null) {
                        File f = new File(path);
                        if (f.isFile() && !f.isHidden()) {
                            ItemImage itemImage = new ItemImage();
                            itemImage.setPath(path);
                            int columnNameFile = cursor.getColumnIndex(MediaStore.Images.Media.TITLE);
                            if (columnNameFile > -1) {
                                itemImage.setNameTitleImage(cursor.getString(columnNameFile));
                            }
                            int columnName = cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
                            if (columnName > -1) {
                                itemImage.setNameFileImage(cursor.getString(columnName));
                            }

                            int columnSize = cursor.getColumnIndex(MediaStore.Images.Media.SIZE);
                            if (columnSize > -1) {
                                itemImage.setSize(cursor.getLong(columnSize));
                            }
                            int columnDateModify = cursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED);
                            if (columnDateModify > -1) {
                                //DATE_MODIFIED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                itemImage.setTimeModified(cursor.getLong(columnDateModify) * 1000);
                            }
                            int columnDateAdded = cursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED);
                            if (columnDateAdded > -1) {
                                //DATE_ADDED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                itemImage.setTimeAdded(cursor.getLong(columnDateAdded) * 1000);
                            }

                            int columnId = cursor.getColumnIndex(MediaStore.Images.Media._ID);
                            if (columnId > -1) {
                                itemImage.setImageId(cursor.getString(columnId));
                            }

                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                                int columnFolderName = cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
                                itemImage.setNameFolder(cursor.getString(columnFolderName));
                            } else {
                                if (f.getParentFile() != null) {
                                    itemImage.setNameFolder(f.getParentFile().getName());
                                }
                            }
                            Timber.e("tunglt: " + itemImage.toString());
                            listVideo.add(itemImage);
                        }
                    }
                }

            }
            cursor.close();
        }
        return listVideo;
    }
}
