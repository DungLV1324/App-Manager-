package com.example.filemanager.ui.main.main.setting;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentSettingBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.example.filemanager.ui.main.MainActivity;
import com.example.filemanager.util.ViewUtil;

public class SettingFragment extends BaseBindingFragment<FragmentSettingBinding, SettingViewModel> {
    @Override
    protected Class<SettingViewModel> getViewModel() {
        return SettingViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initListener();
    }

    private void initListener() {
        binding.tvLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtil.preventTwoClick(v, 500);
                ((MainActivity)requireActivity()).navController.navigate(R.id.fragment_language);
            }
        });
    }
}
