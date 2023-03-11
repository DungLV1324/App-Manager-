package com.example.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewUtil {
    public static void preventTwoClick(View view, int time) {
        if (view.isAttachedToWindow()) {
            view.setEnabled(false);
            new Handler(Looper.getMainLooper()).postDelayed(() -> view.setEnabled(true), time);
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static void showSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static int getWidthScreen() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getHeightScreen() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
