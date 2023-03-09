package com.example.filemanager.ui.main.home.home.images;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentImageBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class ImagesFragment extends BaseBindingFragment<FragmentImageBinding,ImagesViewModel> {
    @Override
    protected Class<ImagesViewModel> getViewModel() {
        return ImagesViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
