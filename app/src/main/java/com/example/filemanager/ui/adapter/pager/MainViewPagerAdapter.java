package com.example.filemanager.ui.adapter.pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.filemanager.ui.main.main.favourite.FavouriteFragment;
import com.example.filemanager.ui.main.main.folder.FolderFragment;
import com.example.filemanager.ui.main.main.home.HomeFragment;
import com.example.filemanager.ui.main.main.setting.SettingFragment;


public class MainViewPagerAdapter extends FragmentStateAdapter {
    private HomeFragment homeFragment;
    private FolderFragment folderFragment;
    private FavouriteFragment favouriteFragment;
    private SettingFragment settingFragment;

    public MainViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                if (homeFragment == null)
                    homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                if (folderFragment == null)
                    folderFragment = new FolderFragment();
                return folderFragment;
            case 2:
                if (favouriteFragment == null)
                    favouriteFragment = new FavouriteFragment();
                return favouriteFragment;
            case 3:
                if (settingFragment == null)
                    settingFragment = new SettingFragment();
                return settingFragment;
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
