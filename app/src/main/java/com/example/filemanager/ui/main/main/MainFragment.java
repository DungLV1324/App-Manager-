package com.example.filemanager.ui.main.main;

import static android.os.Build.VERSION.SDK_INT;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.filemanager.R;
import com.example.filemanager.common.Constant;
import com.example.filemanager.common.MessageEvent;
import com.example.filemanager.databinding.FragmentMainBinding;
import com.example.filemanager.ui.adapter.pager.MainViewPagerAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;
import com.example.filemanager.ui.dialog.DeniedPermissionDialogFragment;
import com.example.filemanager.ui.dialog.DialogPermission;
import com.example.filemanager.util.PermissionUtil;
import com.example.filemanager.util.SettingIntentUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends BaseBindingFragment<FragmentMainBinding, MainFragmentViewModel> {
    private DialogPermission dialogPermission;
    private DeniedPermissionDialogFragment deniedPermissionDialogFragment;
    private final ActivityResultLauncher<String> requestPermissionStorageBelow11 = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            result -> {
                if (result) {
                    initData();
                } else {
                    showDialogDeniedPermission();
                }
            }
    );

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
        requestPermissionStorage();
        initViewPager();
        initListener();
        observerData();
    }

    private void observerData() {
        mainViewModel.liveEvent.observe(getViewLifecycleOwner(), new Observer() {
            @Override
            public void onChanged(Object o) {
                switch (((MessageEvent) o).getTypeEvent()) {
                    case Constant.GRANT_REQUEST_PERMISSION:
                        initData();
                        break;
                }
            }
        });
    }

    private void initListener() {
    }

    private void initData() {

    }

    private void showDialogDeniedPermission() {
        if (deniedPermissionDialogFragment == null) {
            if (getChildFragmentManager().findFragmentByTag(DeniedPermissionDialogFragment.class.getName()) instanceof DeniedPermissionDialogFragment) {
                deniedPermissionDialogFragment = (DeniedPermissionDialogFragment) getChildFragmentManager().findFragmentByTag(DeniedPermissionDialogFragment.class.getName());
            } else {
                deniedPermissionDialogFragment = new DeniedPermissionDialogFragment();
            }
        }
        if (deniedPermissionDialogFragment != null) {
            deniedPermissionDialogFragment.setTextContent("Storage permission has been lost, please re-grant it");
            deniedPermissionDialogFragment.setIClickDeniedPermission(new DeniedPermissionDialogFragment.IClickDeniedPermission() {
                @Override
                public void clickCancel() {

                }

                @Override
                public void clickDone() {
                    SettingIntentUtil.intentSettingApp(requireContext());
                }
            });
            deniedPermissionDialogFragment.show(getChildFragmentManager(), DeniedPermissionDialogFragment.class.getName());
        }
    }

    private void requestPermissionStorage() {
        if (SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                initData();
            } else {
                if (dialogPermission == null) {
                    if (getChildFragmentManager().findFragmentByTag(DialogPermission.class.getName()) instanceof DialogPermission) {
                        dialogPermission = (DialogPermission) getChildFragmentManager().findFragmentByTag(DialogPermission.class.getName());
                    } else {
                        dialogPermission = new DialogPermission();
                    }
                }
                if (dialogPermission != null) {
                    dialogPermission.show(getChildFragmentManager(), DialogPermission.class.getName());
                }
            }
        } else {
            if (PermissionUtil.checkPermissionStorage(requireContext())) {
                initData();
            } else {
                requestPermissionStorageBelow11.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        }
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
