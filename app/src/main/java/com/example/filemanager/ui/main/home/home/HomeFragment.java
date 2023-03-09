package com.example.filemanager.ui.main.home.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentHomeBinding;
import com.example.filemanager.databinding.FragmentStartBinding;
import com.example.filemanager.ui.adapter.MenuBottomAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.google.android.material.navigation.NavigationBarView;

public class HomeFragment extends BaseBindingFragment<FragmentStartBinding,HomeViewModel> {
    @Override
    protected Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_start;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        viewpager();

    }
    public void viewpager() {
        MenuBottomAdapter menuBottomAdapter = new MenuBottomAdapter(getChildFragmentManager(), getLifecycle());
        binding.viewpager2.setAdapter(menuBottomAdapter);
        //tắt scroll viewpager
        binding.viewpager2.setUserInputEnabled(false);
        binding.btnMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fragment_home:
                        binding.viewpager2.setCurrentItem(0);
                        break;

                }
                return true;
            }
        });
    }
}
