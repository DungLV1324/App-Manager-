package com.example.filemanager.ui.main.zip;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentZipBinding;
import com.example.filemanager.model.Zip;
import com.example.filemanager.model.Zip;

import com.example.filemanager.ui.adapter.recycler.ZipAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class ZipFragment extends BaseBindingFragment<FragmentZipBinding, ZipViewModel> {
    private final List<Zip> listZip = new LinkedList<>();

    private ZipAdapter zipAdapter;

    @Override
    protected Class<ZipViewModel> getViewModel() {
        return ZipViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zip;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
    }
    public void initAdapter() {
        zipAdapter = new ZipAdapter();
        binding.listZip.setAdapter(zipAdapter);
    }
    public void initData() {
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listZip.add(new Zip("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        zipAdapter.setListZip(listZip);

    }
}
