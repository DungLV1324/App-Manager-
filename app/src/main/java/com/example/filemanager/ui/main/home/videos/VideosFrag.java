package com.example.filemanager.ui.main.home.videos;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentVideoBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class VideosFrag extends BaseBindingFragment<FragmentVideoBinding,VideosVM> {
    @Override
    protected Class<VideosVM> getViewModel() {
        return VideosVM.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
