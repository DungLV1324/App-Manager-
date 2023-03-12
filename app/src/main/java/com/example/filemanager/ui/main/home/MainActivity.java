package com.example.filemanager.ui.main.home;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ActivityMainBinding;
import com.example.filemanager.ui.base.BaseBindingActivity;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding, MainViewModel> {
    public NavHostFragment navHostFragment;
    public NavController navController;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_edit;
    }

    @Override
    public void setupView(Bundle savedInstanceState) {
//        navHostFragment =
//                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//        if (navHostFragment != null) {
//            navController = navHostFragment.getNavController();
//        }

    }

    @Override
    public void setupData() {

    }

    @Override
    protected Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }
}