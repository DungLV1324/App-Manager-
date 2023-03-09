package com.example.filemanager.ui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;

public abstract class BaseBindingActivity<B extends ViewDataBinding, T extends BaseViewModel> extends BaseActivity {
    public B binding;
    public T viewModel;

    public abstract int getLayoutId();

    public abstract void setupView(Bundle savedInstanceState);

    public abstract void setupData();

    protected abstract Class<T> getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        LocaleUtils.applyLocale(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = new ViewModelProvider(this).get(getViewModel());
        setupData();
        setupView(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
//        LocaleUtils.applyLocale(newBase);
        super.attachBaseContext(newBase);

    }



}

