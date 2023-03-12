package com.example.filemanager.ui.main.detail.image;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentDetailImageBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class DetailImageFragment extends BaseBindingFragment<FragmentDetailImageBinding, DetailImageViewModel> {
    @Override
    protected Class<DetailImageViewModel> getViewModel() {
        return DetailImageViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_image;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
