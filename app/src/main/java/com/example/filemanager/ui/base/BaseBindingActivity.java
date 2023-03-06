package com.example.filemanager.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseBindingActivity<B extends ViewDataBinding> extends BaseActivity {

    public B binding;

    public abstract int getLayoutId();

//    public abstract Class<VM> getViewModel();

    public abstract void setupView(Bundle savedInstanceState);

    public abstract void setupData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
//        viewModel = new ViewModelProvider(this).get(getViewModel());
        setupView(savedInstanceState);
        setupData();
    }
}
