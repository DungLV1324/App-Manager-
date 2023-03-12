package com.example.filemanager.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.filemanager.R;

public class ChartIndicator extends View {


    private int indicatorColor;
    private float cornerRadius;
    private Paint paint;
    private RectF indicator;

    public ChartIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public void init(Context ctx, AttributeSet attrs) {
        // if attrs were set via xml
        if (attrs != null) {
            // get the attributes from the attrs.xml
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ChartIndicator);
            this.indicatorColor = ta.getColor(R.styleable.ChartIndicator_indicatorColor, ContextCompat.getColor(ctx, R.color.default_bar_color));
            this.cornerRadius = ta.getDimension(R.styleable.ChartIndicator_cornerRadiusChart, 0);
            ta.recycle();
        }

        indicator = new RectF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int fullWidth = getWidth();
        int fullHeight = getHeight();

        indicator.top = 0;
        indicator.left = 0;
        indicator.right = fullWidth;
        indicator.bottom = fullHeight;

        paint.setColor(indicatorColor);
        canvas.drawRoundRect(indicator, cornerRadius, cornerRadius, paint);
    }
}

