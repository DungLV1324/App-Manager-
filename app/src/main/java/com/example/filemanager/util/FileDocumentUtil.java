package com.example.filemanager.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.filemanager.data.model.ItemDocument;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import timber.log.Timber;

public class FileDocumentUtil {

    public static ItemDocument getDocumentByUri(Context context, Uri uri) {
        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.MIME_TYPE,
                MediaStore.Files.FileColumns.DATE_ADDED,
                MediaStore.Files.FileColumns.DATE_MODIFIED,
                MediaStore.Files.FileColumns.DISPLAY_NAME,
                MediaStore.Files.FileColumns.TITLE,
                MediaStore.Files.FileColumns.SIZE,
                MediaStore.Files.FileColumns.DATA
        };

        Cursor cursor = context.getContentResolver().query(uri,
                projection,
                null,
                null,
                MediaStore.Files.FileColumns.DATE_MODIFIED /*+ Constant.KEY_DESC*/);


        ItemDocument document = null;
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int columnPath = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);
                String path = null;
                if (columnPath > -1) {
                    path = cursor.getString(columnPath);
                    if (path != null && !path.isEmpty()) {

                        if (endWithPdf(path) || endWithDoc(path) || endWithXlsx(path) || endWithTxt(path) || endWithPPt(path)) {
                            File file = new File(path);
                            if (file.isFile() && file.exists()) {
                                document = new ItemDocument();
                                document.setPath(path);
                                int columnNameFile = cursor.getColumnIndex(MediaStore.Files.FileColumns.TITLE);
                                if (columnNameFile > -1) {
                                    document.setNameFile(cursor.getString(columnNameFile));
                                }

                                int columnSize = cursor.getColumnIndex(MediaStore.Files.FileColumns.SIZE);
                                if (columnSize > -1) {
                                    document.setSize(cursor.getLong(columnSize));
                                }
                                int columnDateModify = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATE_MODIFIED);
                                if (columnDateModify > -1) {
                                    //DATE_MODIFIED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                    document.setTimeModified(cursor.getLong(columnDateModify) * 1000);
                                }
                                int columnDateAdded = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATE_ADDED);
                                if (columnDateAdded > -1) {

                                    //DATE_ADDED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                    document.setTimeAdded(cursor.getLong(columnDateAdded) * 1000);
                                }

                                int columnId = cursor.getColumnIndex(MediaStore.Files.FileColumns._ID);
                                if (columnId > -1) {
                                    document.setFileId(cursor.getString(columnId));
                                }

                                int columnCategoryFile = cursor.getColumnIndex(MediaStore.Files.FileColumns.DISPLAY_NAME);
                                if (columnCategoryFile > -1) {
                                    String category = cursor.getString(columnCategoryFile);
                                    document.setCategory(category != null ? category.substring(category.lastIndexOf(".") + 1) : "");
                                }
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                                    int columnFolderName = cursor.getColumnIndex(MediaStore.Files.FileColumns.BUCKET_DISPLAY_NAME);
                                    document.setNameFolder(cursor.getString(columnFolderName));
//                                Timber.e("tunglt: name folder: " + document.getNameFolder());
                                } else {
                                    if (file.getParentFile() != null) {
                                        document.setNameFolder(file.getParentFile().getName());
                                    }
                                }
                                Timber.e("tunglt: document: " + document.toString());
                            }
                        }
                    }
                }
            }
            cursor.close();
        }

        return document;
    }


    public static List<ItemDocument> getAllFileDocument(Context context) {
        String[] projection = {
                MediaStore.Files.FileColumns._ID,
                MediaStore.Files.FileColumns.MIME_TYPE,
                MediaStore.Files.FileColumns.DATE_ADDED,
                MediaStore.Files.FileColumns.DATE_MODIFIED,
                MediaStore.Files.FileColumns.DISPLAY_NAME,
                MediaStore.Files.FileColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Files.FileColumns.TITLE,
                MediaStore.Files.FileColumns.SIZE,
                MediaStore.Files.FileColumns.DATA
        };
        Uri uri = null;
        uri = MediaStore.Files.getContentUri("external");
        Cursor cursor = context.getContentResolver().query(uri,
                projection,
                null,
                null,
                MediaStore.Files.FileColumns.DATE_MODIFIED + " DESC");
        List<ItemDocument> documentList = new LinkedList<>();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int columnPath = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA);
                String path = null;
                if (columnPath > -1) {
                    path = cursor.getString(columnPath);
                    if (path != null && !path.isEmpty()) {

                        if (endWithPdf(path) || endWithDoc(path) || endWithXlsx(path) || endWithTxt(path) || endWithPPt(path)) {
                            File file = new File(path);
                            if (file.isFile() && file.exists()) {
                                ItemDocument document = new ItemDocument();
                                document.setPath(path);
                                int columnNameFile = cursor.getColumnIndex(MediaStore.Files.FileColumns.TITLE);
                                if (columnNameFile > -1) {
                                    document.setNameFile(cursor.getString(columnNameFile));
                                }

                                int columnSize = cursor.getColumnIndex(MediaStore.Files.FileColumns.SIZE);
                                if (columnSize > -1) {
                                    document.setSize(cursor.getLong(columnSize));
                                }
                                int columnDateModify = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATE_MODIFIED);
                                if (columnDateModify > -1) {
                                    //DATE_MODIFIED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                    document.setTimeModified(cursor.getLong(columnDateModify) * 1000);
                                }
                                int columnDateAdded = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATE_ADDED);
                                if (columnDateAdded > -1) {

                                    //DATE_ADDED is in seconds since 1970, so just multiply it by 1000 and it'll be fine
                                    document.setTimeAdded(cursor.getLong(columnDateAdded) * 1000);
                                }

                                int columnId = cursor.getColumnIndex(MediaStore.Files.FileColumns._ID);
                                if (columnId > -1) {
                                    document.setFileId(cursor.getString(columnId));
                                }

                                int columnCategoryFile = cursor.getColumnIndex(MediaStore.Files.FileColumns.DISPLAY_NAME);
                                if (columnCategoryFile > -1) {
                                    String category = cursor.getString(columnCategoryFile);
                                    document.setCategory(category != null ? category.substring(category.lastIndexOf(".") + 1) : "");
                                }
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                                    int columnFolderName = cursor.getColumnIndex(MediaStore.Files.FileColumns.BUCKET_DISPLAY_NAME);
                                    document.setNameFolder(cursor.getString(columnFolderName));
//                                Timber.e("tunglt: name folder: " + document.getNameFolder());
                                } else {
                                    if (file.getParentFile() != null) {
                                        document.setNameFolder(file.getParentFile().getName());
                                    }
                                }
                                Timber.e("tunglt: document: " + document.toString());
                                documentList.add(document);
                            }

                        }

                    }
                }

            }
            cursor.close();
        }
        return documentList;
    }


    public static boolean endWithDoc(String path) {
        return path.endsWith(FileUtil.TYPE_DOC_X)
                || path.endsWith(FileUtil.TYPE_DOC);
    }

    public static boolean endWithPdf(String path) {
        return path.endsWith("." + FileUtil.TYPE_PDF);
    }

    public static boolean endWithXlsx(String path) {
        return path.endsWith(FileUtil.TYPE_XLSX)
                || path.endsWith(FileUtil.TYPE_XLS);
    }

    public static boolean endWithPPt(String path) {
        return path.endsWith(FileUtil.TYPE_PPT)
                || path.endsWith(FileUtil.TYPE_PPTX)
                || path.endsWith(FileUtil.TYPE_PPS)
                || path.endsWith(FileUtil.TYPE_PPTM);
    }

    public static boolean endWithTxt(String path) {
        return path.endsWith(FileUtil.TYPE_TXT);
    }


    public static boolean isPdfFiles(String typeFile) {
        return typeFile.equals(FileUtil.TYPE_PDF);
    }

    public static boolean isDocFiles(String typeFile) {
        return typeFile.equals(FileUtil.TYPE_DOC_X)
                || typeFile.equals(FileUtil.TYPE_DOC)
                || typeFile.equals("application/msword");
    }

    public static boolean isExcelFiles(String typeFile) {
        return typeFile.equals(FileUtil.TYPE_XLSX)
                || typeFile.equals(FileUtil.TYPE_XLS)
                || typeFile.equals("application/vnd.ms-excel");
    }

    public boolean isPptFiles(String typeFile) {
        return typeFile.equals(FileUtil.TYPE_PPTX)
                || typeFile.equals(FileUtil.TYPE_PPS)
                || typeFile.equals(FileUtil.TYPE_PPTM)
                || typeFile.equals(FileUtil.TYPE_PPT)
                || typeFile.equals("application/vnd.ms-powerpoint");
    }

}
