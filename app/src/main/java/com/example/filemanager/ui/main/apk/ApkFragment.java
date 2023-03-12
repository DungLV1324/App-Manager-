package com.example.filemanager.ui.main.apk;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentApkBinding;
import com.example.filemanager.model.Apk;
import com.example.filemanager.ui.adapter.recycler.ApkAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class ApkFragment extends BaseBindingFragment<FragmentApkBinding, ApkViewModel> {
    private final List<Apk> listApk = new LinkedList<>();
    private ApkAdapter apkAdapter;

    @Override
    protected Class<ApkViewModel> getViewModel() {
        return ApkViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_apk;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
    }

    public void initAdapter() {
        apkAdapter = new ApkAdapter();
        binding.listApk.setAdapter(apkAdapter);
    }

    public void initData() {
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        listApk.add(new Apk("Backgroundcolorfuldobeautiful.png", "8/3/2023 10:00  CH 100KB"));
        apkAdapter.setListApk(listApk);

    }
}
