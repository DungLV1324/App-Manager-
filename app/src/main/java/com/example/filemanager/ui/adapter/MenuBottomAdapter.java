package com.example.filemanager.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.filemanager.ui.main.home.home.HomeFragment;


public class MenuBottomAdapter extends FragmentStateAdapter {

    public MenuBottomAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return  new HomeFragment();
        }
        return new  HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
