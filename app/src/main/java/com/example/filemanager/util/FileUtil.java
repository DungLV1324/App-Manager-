package com.example.filemanager.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import com.example.filemanager.BuildConfig;
import com.example.filemanager.data.model.ItemFile;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import timber.log.Timber;

public class FileUtil {
    public static List<ItemFile> getAllFileFromStorage() {
        List<ItemFile> fileList = new LinkedList<>();
        String path = Environment.getExternalStorageDirectory().toString();
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
//                Timber.e("tunglt: itemFile: " + file.toString());
                ItemFile itemFile = new ItemFile(path);
                fileList.add(itemFile);
            }
        }
        return fileList;

    }

//    public static void unRar() {
//        Completable.fromAction(() -> {
//            RarFile rar = new RarFile("/storage/emulated/0/zazip_vn.tapbi.zazip.rar");
//            try {
//                rar.extractAll("/storage/emulated/0/tung", new UnrarCallback() {
//                    @Override
//                    public void processData(ByteBuffer buffer, int len) {
//
//                    }
//
//                    @Override
//                    public String needPassword() {
//                        return null;
//                    }
//
//                    @Override
//                    public void close() throws IOException {
//
//                    }
//                });
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }).subscribeOn(Schedulers.io()).subscribe();
//    }

    /**
     * Install .apk file.
     */
    public static void installApk(
            final @NonNull File f, Context context) {

        try {
            PackageInstallValidation.validatePackageInstallability(f);
        } catch (PackageInstallValidation.PackageCannotBeInstalledException e) {
            Toast.makeText(context, "failed to install apk", Toast.LENGTH_LONG).show();
            return;
        } catch (IllegalStateException e) {
            Toast.makeText(context, "failed to install apk", Toast.LENGTH_LONG).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                && !context.getPackageManager().canRequestPackageInstalls()) {
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        String type = "application/vnd.android.package-archive";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri downloadedApk =
                    FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", f);
            intent.setDataAndType(downloadedApk, type);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            intent.setDataAndType(Uri.fromFile(f), type);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            Timber.e("tunglt: failed to install apk");
            Toast.makeText(context, "failed to install apk", Toast.LENGTH_LONG).show();
        }
    }


    public static final String TYPE_DOC = "type_doc";

    public static final String TYPE_XLSM = "xlsm";
    public static final String TYPE_PDF = "pdf";
    public static final String TYPE_DOC_X = "docx";
    public static final String TYPE_DOCS = "doc";
    public static final String TYPE_XLSX = "xlsx";
    public static final String TYPE_XLS = "xls";
    public static final String TYPE_TXT = "txt";
    public static final String TYPE_PPT = "ppt";
    public static final String TYPE_PPTX = "pptx";
    public static final String TYPE_PPS = "pps";
    public static final String TYPE_PPTM = "pptm";
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_JPEG = "jpeg";
    public static final String TYPE_PNG = "png";
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_BMP = "bmp";
    public static final String TYPE_WEBP = "webp";
    public static final String TYPE_HEIC = "heic";
    public static final String TYPE_TIFF = "tiff";
    public static final String TYPE_PSD = "psd";
    public static final String TYPE_EPS = "eps";
    public static final String TYPE_AI = "ai";
    public static final String TYPE_INDD = "indd";
    public static final String TYPE_TGA = "tga";
    public static final String TYPE_AC3 = "ac3";
    public static final String TYPE_AMR = "amr";
    public static final String TYPE_MP3 = "mp3";
    public static final String TYPE_AIFF = "aiff";
    public static final String TYPE_OGG = "ogg";
    public static final String TYPE_WMA = "wma";
    public static final String TYPE_FLAC = "flac";
    public static final String TYPE_WAV = "wav";
    public static final String TYPE_OGA = "oga";
    public static final String TYPE_M4A = "m4a";
    public static final String TYPE_AAC = "aac";
    public static final String TYPE_MIDI = "midi";
    public static final String TYPE_PCM = "pcm";
    public static final String TYPE_AIF = "aif";
    public static final String TYPE_ALAC = "alac";
    public static final String TYPE_WMA9 = "wma9";
    public static final String TYPE_MP2 = "mp2";
    public static final String TYPE_MP1 = "mp1";
    public static final String TYPE_MP4 = "mp4";
    public static final String TYPE_MKV = "mkv";
    public static final String TYPE_WMV = "wmv";
    public static final String TYPE_VOB = "vob";
    public static final String TYPE_FLV = "flv";
    public static final String TYPE_DLVX = "dlvx";
    public static final String TYPE_AVI = "avi";
    public static final String TYPE_XVID = "xvid";
    public static final String TYPE_MPGE = "mpeg";
    public static final String TYPE_WEBV = "webv";
    public static final String TYPE_3GP = "3gp";
    public static final String TYPE_MOV = "mov";
    public static final String TYPE_NULL = "null";
}
