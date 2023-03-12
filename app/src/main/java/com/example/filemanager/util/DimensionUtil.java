package com.example.filemanager.util;

import android.content.res.Resources;

public class DimensionUtil {
    public static float dpFromPx(final float px) {
        return px / Resources.getSystem().getDisplayMetrics().density;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int convertSpToPx(float sp) {
        return (int) (sp * Resources.getSystem().getDisplayMetrics().density);
    }
}
