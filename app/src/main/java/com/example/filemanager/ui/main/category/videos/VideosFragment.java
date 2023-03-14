package com.example.filemanager.ui.main.category.videos;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentVideoBinding;
import com.example.filemanager.model.Video;
import com.example.filemanager.model.VideoThumb;
import com.example.filemanager.ui.adapter.recycler.VideoAdapter;
import com.example.filemanager.ui.adapter.recycler.VideoThumbAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class VideosFragment extends BaseBindingFragment<FragmentVideoBinding, VideosViewModel> {
   
    private final List<Video> listVideo = new LinkedList<>();
    private final List<VideoThumb> listVideoThumb = new LinkedList<>();

    boolean iSelect = false;

   private VideoAdapter videoAdapter;
   private VideoThumbAdapter videoThumbAdapter;
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
        initAdapterThumb();
        initDataThumb();


        binding.imMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imMenu.setImageResource(R.drawable.ic_menu);
                binding.listVideo.setVisibility(View.VISIBLE);
                binding.listVideoThumb.setVisibility(View.INVISIBLE);

                if (iSelect){
                    iSelect = false;
                    binding.listVideoThumb.setVisibility(View.INVISIBLE);
                    binding.listVideo.setVisibility(View.VISIBLE);
                    binding.imMenu.setImageResource(R.drawable.list_soid);
                }else {
                    iSelect = true;
                    binding.listVideoThumb.setVisibility(View.VISIBLE);
                    binding.listVideo.setVisibility(View.INVISIBLE);
                    binding.imMenu.setImageResource(R.drawable.ic_menu);
                }
            }
        });


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

    }  public void initAdapterThumb() {
        videoThumbAdapter = new VideoThumbAdapter();
        binding.listVideoThumb.setAdapter(videoThumbAdapter);
    }
    public void initDataThumb() {
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        listVideoThumb.add(new VideoThumb("Backgroundcolorfuldobeautiful.png"));
        videoThumbAdapter.setListVideoThumb(listVideoThumb);

    }
}
