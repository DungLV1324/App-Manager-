package com.example.filemanager.util;

import java.util.Locale;

public class FileArchiveUtil {
    public static final String ARCHIVE_ZIP = ".zip";
    public static final String ARCHIVE_7ZIP = ".7z";
    public static final String ARCHIVE_TAR = ".tar";
    public static final String ARCHIVE_BZ2 = ".bz2";
    public static final String ARCHIVE_GZ = ".gz";
    public static final String ARCHIVE_XZ = ".xz";
    public static final String ARCHIVE_TGZ = ".tgz";
    public static final String ARCHIVE_TBZ2 = ".tbz2";
    public static final String ARCHIVE_TBZ = ".tbz";
    public static final String ARCHIVE_TXZ = ".txz";
    public static final String ARCHIVE_RAR = ".rar";
    public static final String ARCHIVE_LZ4 = ".lz4";
    public static final String ARCHIVE_TLZ4 = ".tlz4";
    public static final String ARCHIVE_ZST = ".zst";
    public static final String ARCHIVE_TAR_LZ4 = ".tar.lz4";
    public static final String ARCHIVE_TAR_ZST = ".tar.zst";
    public static final String ARCHIVE_TAR_GZ = ".tar.gz";
    public static final String ARCHIVE_TAR_XZ = ".tar.xz";
    public static final String ARCHIVE_TAR_BZ2 = ".tar.bz2";

    public static boolean isArchiveFile(String path) {
        return (path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_ZIP)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_RAR)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_7ZIP)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TAR)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_BZ2)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TLZ4)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TGZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_GZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TBZ2)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TBZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_XZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_LZ4)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_ZST)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TXZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TAR_LZ4)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TAR_GZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TAR_ZST)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TAR_XZ)
                || path.toLowerCase(Locale.ROOT).endsWith(ARCHIVE_TAR_BZ2)
        );
    }
}
