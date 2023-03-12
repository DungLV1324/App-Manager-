package com.example.filemanager.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.webkit.MimeTypeMap;

public class BitmapUtils {

    public static Bitmap blurImage(Context mContext, Bitmap bitmap, float radius, int ratio) {
        Bitmap mInBitmap =
                Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / ratio,
                        bitmap.getHeight() / ratio, true);
        Bitmap mOutBitmap = Bitmap.createBitmap(mInBitmap.getWidth(), mInBitmap.getHeight(),
                mInBitmap.getConfig());
        RenderScript mRenderScript = RenderScript.create(mContext);
        Allocation input = Allocation.createFromBitmap(mRenderScript, mInBitmap);
        Allocation output = Allocation.createTyped(mRenderScript, input.getType());
        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(mRenderScript,
                Element.U8_4(mRenderScript));
        script.setRadius(radius);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(mOutBitmap);
        if (!mInBitmap.isRecycled()) {
            mInBitmap.recycle();
        }
        return mOutBitmap;
    }


//    public static Bitmap getBitmapFromView(View view) {
//        int width = view.getWidth();
//        int height = view.getHeight();
//        if (width == 0 || height == 0) {
//            return null;
//        }
//        var measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
//        var measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
//        measuredWidth = measuredWidth == 0 ? width : measuredWidth;
//        measuredHeight = measuredHeight == 0 ? height : measuredHeight;
//        view.measure(measuredWidth, measuredHeight);
//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
//        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        view.draw(new Canvas(b));
//        return b;
//    }

    // Return image file format(PNG,JPG,...)
    public static String getExtensionBitmap(Uri uri, Context context) {
        String extension;
        ContentResolver contentResolver = context.getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        extension = mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
        return extension;
    }


    //Return bitmap transparent with alpha
    public static Bitmap makeTransparentBitmap(Bitmap src, int value) {
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap transBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(transBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        // config paint
        final Paint paint = new Paint();
        paint.setAlpha(value);
        canvas.drawBitmap(src, 0, 0, paint);
        return transBitmap;
    }

    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(bitmap.getWidth() / 2f, bitmap.getHeight() / 2f, bitmap.getWidth() / 2f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, (float) pixels, (float) pixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }


    //Return bitmap with color normal or gradient
    public static Bitmap fillerColorBitmap(Bitmap bitmap, String color, int width, int height) {
        if (bitmap == null || bitmap.getWidth() == 0 && bitmap.getHeight() == 0) return null;
        String[] colors = color.split("\\.");
        Bitmap result = Bitmap.createScaledBitmap(bitmap, width, height, true);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(result);
        if (colors.length == 1) {
            ColorFilter colorFilter = new PorterDuffColorFilter(Color.parseColor(colors[0]),
                    PorterDuff.Mode.SRC_IN);
            paint.setColorFilter(colorFilter);
        } else {
            LinearGradient gradient = new LinearGradient(0, 0, 0, bitmap.getHeight(),
                    Color.parseColor(colors[0]), Color.parseColor(colors[1]), Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawRect(0, 0, width, height, paint);
        }
        canvas.drawBitmap(result, 0, 0, paint);
        return result;
    }


    public static Bitmap rotateBitmap(Bitmap bitmap, float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap resizeBitmapFitRemoteView(Bitmap bitmap) {
        if (bitmap != null) {
            boolean isFitSize = false;
            while (!isFitSize) {
                int sizeBitmap = BitmapUtils.getSizeBitmap(bitmap);
                float sizeRemoteView = BitmapUtils.getSizeRemoteViews();
                if (sizeBitmap >= sizeRemoteView) {
                    bitmap = scaleBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
                } else {
                    isFitSize = true;
                }
            }
            return bitmap;
        }
        return null;
    }

    private static int getSizeBitmap(Bitmap data) {
        return data.getByteCount();
    }

    private static float getSizeRemoteViews() {
        return ViewUtil.getWidthScreen() * ViewUtil.getHeightScreen() * 4;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap1, int w, int h) {
        int width = bitmap1.getWidth();
        int height = bitmap1.getHeight();
        boolean isResize = false;
        if (width >= height && width > w) {
            height = w * height / width;
            width = w;
            isResize = true;
        } else if (height > width && height > h) {
            width = h * width / height;
            height = h;
            isResize = true;
        }
        if (width % 2 != 0) {
            width += 1;
            isResize = true;
        }
        if (height % 2 != 0) {
            height += 1;
            isResize = true;
        }
        if (isResize) {
            bitmap1 = Bitmap.createScaledBitmap(bitmap1, width, height, false);
        }
        return bitmap1;
    }


}
