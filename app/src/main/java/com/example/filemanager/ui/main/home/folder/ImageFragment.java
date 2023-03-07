package com.example.filemanager.ui.main.home.folder;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentImageBinding;
import com.example.filemanager.modle.Image;
import com.example.filemanager.ui.adapter.ImageAdapter;
import java.util.LinkedList;
import java.util.List;

public class ImageFragment extends Fragment {
    private final List<Image> listImage = new LinkedList<>();

    FragmentImageBinding binding;
    private ImageAdapter imageAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_image, null, false);
        binding.imSearch.setOnClickListener(v -> {});
        binding.tvTitle.setOnClickListener(v -> {});
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        initData();
    }

    public void initAdapter(){
        imageAdapter=new ImageAdapter();
        binding.listImage.setAdapter(imageAdapter);
    }
    public void initData(){

      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      listImage.add(new Image("Backgroundcolorfuldobeautiful.png","8/3/2023 10:00  CH 100KB"));
      imageAdapter.setListImage(listImage);

    }
}
