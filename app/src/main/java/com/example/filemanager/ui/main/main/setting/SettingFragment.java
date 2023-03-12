package com.example.filemanager.ui.main.main.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.filemanager.BuildConfig;
import com.example.filemanager.R;
import com.example.filemanager.common.Constant;
import com.example.filemanager.common.MessageEvent;
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
        binding.tvLanguage.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_language);
        });
        binding.tvShareFileManager.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(
                        Intent.EXTRA_SUBJECT,
                        requireContext().getString(R.string.app_name)
                );
                String shareMessage = getString(R.string.let_me_recoomend_this_application);
                shareMessage = shareMessage + getString(R.string.link_google_store) + BuildConfig.APPLICATION_ID;
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, getString(R.string.chosse_one)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        binding.tvPolicy.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            ((MainActivity) requireActivity()).navController.navigate(R.id.fragment_policy);
            mainViewModel.liveEvent.postValue(new MessageEvent(Constant.NAVIGATE_WEB_VIEW, getString(R.string.link_policy)));
        });
    }
}
