package com.example.filemanager.ui.main.home.main.favourite;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentFavouriteBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class FavouriteFragment extends BaseBindingFragment<FragmentFavouriteBinding, FavouriteViewModel> {
    @Override
    protected Class<FavouriteViewModel> getViewModel() {
        return FavouriteViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favourite;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
