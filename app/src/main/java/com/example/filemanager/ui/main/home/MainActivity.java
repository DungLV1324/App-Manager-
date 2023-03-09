package com.example.filemanager.ui.main.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ActivityMainBinding;
import com.example.filemanager.ui.base.BaseBindingActivity;
import com.example.filemanager.ui.main.home.home.HomeFragment;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding,MainViewModel> {
    public NavHostFragment navHostFragment;
    public NavController navController;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setupView(Bundle savedInstanceState) {
        navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();




    }

    @Override
    public void setupData() {

    }

    @Override
    protected Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }
}