package com.example.filemanager.ui.main.category.images;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentImageBinding;
import com.example.filemanager.model.Image;
import com.example.filemanager.model.ImageThumb;
import com.example.filemanager.ui.adapter.recycler.ImageAdapter;
import com.example.filemanager.ui.adapter.recycler.ImageThumbAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class ImagesFragment extends BaseBindingFragment<FragmentImageBinding, ImagesViewModel> {
    private final List<Image> listImage = new LinkedList<>();
    private final List<ImageThumb> listImageThumb = new LinkedList<>();
    private ImageAdapter imageAdapter;
    private ImageThumbAdapter imageThumbAdapter;

    boolean iSelect = false;

    @Override
    protected Class<ImagesViewModel> getViewModel() {
        return ImagesViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
        initAdapterImageThumb();
        initDataImageThumb();


        binding.imMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.listImageThumb.setVisibility(View.VISIBLE);
                binding.listImage.setVisibility(View.INVISIBLE);


                if (iSelect){
                    iSelect = false;
                    binding.listImageThumb.setVisibility(View.INVISIBLE);
                    binding.listImage.setVisibility(View.VISIBLE);
                    
                }else {
                    iSelect = true;
                    binding.listImageThumb.setVisibility(View.VISIBLE);
                    binding.listImage.setVisibility(View.INVISIBLE);                }
            }
        });



    }

    public void initAdapter() {
        imageAdapter = new ImageAdapter();
        binding.listImage.setAdapter(imageAdapter);
    }

    public void initData() {
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listImage.add(new Image("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        imageAdapter.setListImage(listImage);

    } public void initAdapterImageThumb() {
        imageThumbAdapter = new ImageThumbAdapter();
        binding.listImageThumb.setAdapter(imageThumbAdapter);
    }

    public void initDataImageThumb() {
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        listImageThumb.add(new ImageThumb("Backgroundcolorfuldobeautiful.png"));
        imageThumbAdapter.setListImageThumb(listImageThumb);
    }
}
