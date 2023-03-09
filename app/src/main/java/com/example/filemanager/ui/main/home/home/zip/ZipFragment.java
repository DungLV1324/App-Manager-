package com.example.filemanager.ui.main.home.home.zip;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentZipBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class ZipFragment extends BaseBindingFragment<FragmentZipBinding, ZipViewModel> {
    @Override
    protected Class<ZipViewModel> getViewModel() {
        return ZipViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zip;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
