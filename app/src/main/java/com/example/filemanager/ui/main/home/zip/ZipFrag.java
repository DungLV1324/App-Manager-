package com.example.filemanager.ui.main.home.zip;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentZipBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class ZipFrag extends BaseBindingFragment<FragmentZipBinding,ZipVM> {
    @Override
    protected Class<ZipVM> getViewModel() {
        return ZipVM.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zip;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
