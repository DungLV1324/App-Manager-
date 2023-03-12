package com.example.filemanager.ui.main.trash;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentTrashBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.List;

public class TrashFragment extends BaseBindingFragment<FragmentTrashBinding, TrashViewModel> {

    @Override
    protected Class<TrashViewModel> getViewModel() {
        return TrashViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trash;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
