package com.example.filemanager.ui.main.home.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentMainBinding;
import com.example.filemanager.ui.adapter.pager.MainViewPagerAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends BaseBindingFragment<FragmentMainBinding, MainFragmentViewModel> {
    @Override
    protected Class<MainFragmentViewModel> getViewModel() {

        return MainFragmentViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initViewPager();

        initListener();
    }

    private void initListener() {
    }

    public void initViewPager() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        binding.viewpager2.setAdapter(mainViewPagerAdapter);
        binding.viewpager2.setUserInputEnabled(false);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fragment_home:
                        binding.viewpager2.setCurrentItem(0);
                        break;
                    case R.id.fragment_folder:
                        binding.viewpager2.setCurrentItem(1);
                        break;
                    case R.id.fragment_favourite:
                        binding.viewpager2.setCurrentItem(2);
                        break;
                    case R.id.fragment_setting:
                        binding.viewpager2.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }
}
