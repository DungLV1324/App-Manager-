package com.example.filemanager.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseBindingActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity {

    public B binding;
    public VM viewModel;

    protected abstract int getLayoutId();

    protected abstract Class<VM> getViewModel();

    protected abstract void setupView(Bundle savedInstanceState);

    protected abstract void setupData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = new ViewModelProvider(this).get(getViewModel());
        setupView(savedInstanceState);
        setupData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
