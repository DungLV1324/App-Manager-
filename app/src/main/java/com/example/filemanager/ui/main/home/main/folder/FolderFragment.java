package com.example.filemanager.ui.main.home.main.folder;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentFolderBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class FolderFragment extends BaseBindingFragment<FragmentFolderBinding, FolderViewModel> {
    @Override
    protected Class<FolderViewModel> getViewModel() {
        return FolderViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_folder;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
