package com.example.filemanager.ui.main.apk;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentApkBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class ApkFragment extends BaseBindingFragment<FragmentApkBinding, ApkViewModel> {
    @Override
    protected Class<ApkViewModel> getViewModel() {
        return ApkViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_apk;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
