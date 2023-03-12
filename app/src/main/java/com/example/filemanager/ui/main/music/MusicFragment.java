package com.example.filemanager.ui.main.music;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentMusicBinding;
import com.example.filemanager.model.Document;
import com.example.filemanager.model.Music;
import com.example.filemanager.ui.adapter.recycler.DocumentAdapter;
import com.example.filemanager.ui.adapter.recycler.MusicAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class MusicFragment extends BaseBindingFragment<FragmentMusicBinding, MusicViewModel> {
    private final List<Music> listMusic = new LinkedList<>();
    private MusicAdapter musicAdapter;
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
        initAdapter();
        initData();
    }

    public void initAdapter() {
        musicAdapter = new MusicAdapter();
        binding.listMusic.setAdapter(musicAdapter);
    }

    public void initData() {
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listMusic.add(new Music("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        musicAdapter.setListMusic(listMusic);

    }
}
