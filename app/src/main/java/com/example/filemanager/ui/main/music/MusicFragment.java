package com.example.filemanager.ui.main.music;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentMusicBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class MusicFragment extends BaseBindingFragment<FragmentMusicBinding, MusicViewModel> {
    @Override
    protected Class<MusicViewModel> getViewModel() {
        return MusicViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
