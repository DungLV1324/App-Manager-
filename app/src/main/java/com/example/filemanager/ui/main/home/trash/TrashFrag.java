package com.example.filemanager.ui.main.home.trash;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentTrashBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class TrashFrag extends BaseBindingFragment<FragmentTrashBinding,TrashVM> {
    @Override
    protected Class<TrashVM> getViewModel() {
        return TrashVM.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trash;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
