package com.example.filemanager.ui.main.home.home.videos;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentVideoBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class VideosFragment extends BaseBindingFragment<FragmentVideoBinding, VideosViewModel> {
    @Override
    protected Class<VideosViewModel> getViewModel() {
        return VideosViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
