package com.example.filemanager.ui.main.main.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentHomeBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.example.filemanager.ui.main.MainActivity;
import com.example.filemanager.util.ViewUtil;

public class HomeFragment extends BaseBindingFragment<FragmentHomeBinding, HomeViewModel> {
    @Override
    protected Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initView();
        initListener();
    }

    private void initView() {

        binding.shadowSeach.setShadowColor(Color.parseColor("#146C2BE0"));
    }

    private void initListener() {
        binding.tvImages.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_image);
        });
        binding.tvVideos.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_video);
        });
        binding.tvDocument.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_document);
        });
        binding.tvMusic.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_music);
        });
        binding.tvApk.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_apk);
        });
        binding.tvDownLoad.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_download);
        });
        binding.tvZip.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_zip);
        });
        binding.tvTrash.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_trash);
        });
    }


}
