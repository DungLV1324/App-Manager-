package com.example.filemanager.ui.main.category.videos;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentVideoBinding;
import com.example.filemanager.model.Video;
import com.example.filemanager.ui.adapter.recycler.VideoAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class VideosFragment extends BaseBindingFragment<FragmentVideoBinding, VideosViewModel> {
   
    private final List<Video> listVideo = new LinkedList<>();
   private VideoAdapter videoAdapter;
    @Override
    protected Class<VideosViewModel> getViewModel() {
        return VideosViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
    }
    public void initAdapter() {
        videoAdapter = new VideoAdapter();
        binding.listVideo.setAdapter(videoAdapter);
    }
    public void initData() {
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listVideo.add(new Video("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        videoAdapter.setListVideo(listVideo);

    }
}
