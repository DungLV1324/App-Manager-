package com.example.filemanager.ui.main.home.main.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentHomeBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.example.filemanager.ui.main.home.MainActivity;
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
        binding.tvImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtil.preventTwoClick(v, 500);
                ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_image);
            }
        });
    }


}
