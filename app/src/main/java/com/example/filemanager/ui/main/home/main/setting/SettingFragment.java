package com.example.filemanager.ui.main.home.main.setting;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentSettingBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

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

    }
}
