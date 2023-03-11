package com.example.filemanager.ui.main.home.home.dowload;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentDownloadBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class DowloadFragment extends BaseBindingFragment<FragmentDownloadBinding, DowloadViewModel> {
    @Override
    protected Class<DowloadViewModel> getViewModel() {
        return DowloadViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_download;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
