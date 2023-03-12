package com.example.filemanager.ui.main.policy;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentPolicyBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.example.filemanager.ui.main.MainActivity;
import com.example.filemanager.util.ViewUtil;

public class PolicyFragment extends BaseBindingFragment<FragmentPolicyBinding, PolicyViewModel> {

    @Override
    protected Class<PolicyViewModel> getViewModel() {
        return PolicyViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_policy;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

        initView();
        initListener();
    }

    private void initView() {
        binding.wvPolicy.post(() -> {
            if (isAdded()) {
                binding.wvPolicy.loadUrl(getString(R.string.link_policy));
            }
        });
    }

    private void initListener() {
        binding.imBack.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            if (binding.wvPolicy.canGoBack()) {
                binding.wvPolicy.goBack();
            } else {
                ((MainActivity) requireActivity()).navController.popBackStack();
            }
        });
    }
}
