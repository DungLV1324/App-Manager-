package com.example.filemanager.ui.main.category.images;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentImageBinding;
import com.example.filemanager.model.Image;
import com.example.filemanager.ui.adapter.recycler.ImageAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class ImagesFragment extends BaseBindingFragment<FragmentImageBinding, ImagesViewModel> {
    private final List<Image> listImage = new LinkedList<>();
    private ImageAdapter imageAdapter;

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

    }
}
