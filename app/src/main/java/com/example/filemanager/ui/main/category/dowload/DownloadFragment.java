package com.example.filemanager.ui.main.category.dowload;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentDownloadBinding;
import com.example.filemanager.model.Download;
import com.example.filemanager.ui.adapter.recycler.DownloadAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class DownloadFragment extends BaseBindingFragment<FragmentDownloadBinding, DownloadViewModel> {
    private final List<Download> listDownload = new LinkedList<>();
    private DownloadAdapter downloadAdapter;

    @Override
    protected Class<DownloadViewModel> getViewModel() {
        return DownloadViewModel.class;

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_download;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
    }

    public void initAdapter() {
        downloadAdapter = new DownloadAdapter();
        binding.listDownload.setAdapter(downloadAdapter);
    }

    public void initData() {
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listDownload.add(new Download("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        downloadAdapter.setListDownload(listDownload);

    }
}
