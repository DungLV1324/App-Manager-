package com.example.filemanager.ui.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.filemanager.databinding.LayoutFileManagerBinding;

public class ViewFileManager extends ConstraintLayout {


    private static final int FREE_SPACE = 1;
    private static final int SYSTEM = 2;
    private static final int APPLICATION = 3;
    private static final int VIDEO = 4;
    private static final int DOCUMENT = 5;

    private LayoutFileManagerBinding binding;

    public ViewFileManager(@NonNull Context context) {
        super(context);

        init(context);
    }

    public ViewFileManager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewFileManager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ViewFileManager(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        binding = LayoutFileManagerBinding.inflate(LayoutInflater.from(context), this, true);

        initHorizontalBar();
    }

    private void initHorizontalBar() {
        binding.progressBar.addData(DOCUMENT, 20, Color.parseColor("#2B94E0"));
        binding.progressBar.addData(VIDEO, 20, Color.parseColor("#E06C2B"));
        binding.progressBar.addData(APPLICATION, 20, Color.parseColor("#48D49E"));
        binding.progressBar.addData(SYSTEM, 20, Color.parseColor("#E0C32B"));
        binding.progressBar.addData(FREE_SPACE, 20, Color.parseColor("#E3F3F4"));
        binding.progressBar.show();
    }
}
