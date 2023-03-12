package com.example.filemanager.ui.main.main.setting.language;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentLanguageBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class LanguageFragment extends BaseBindingFragment<FragmentLanguageBinding, LanguageViewModel> {
    @Override
    protected Class<LanguageViewModel> getViewModel() {
        return LanguageViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_language;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
