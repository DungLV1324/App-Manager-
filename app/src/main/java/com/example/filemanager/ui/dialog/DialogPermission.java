package com.example.filemanager.ui.dialog;

import static android.os.Build.VERSION.SDK_INT;
import static com.example.filemanager.common.Constant.GRANT_REQUEST_PERMISSION;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import com.example.filemanager.R;
import com.example.filemanager.common.MessageEvent;
import com.example.filemanager.databinding.DialogPermissionBinding;
import com.example.filemanager.ui.base.BaseBindingDialogFragment;
import com.example.filemanager.util.ViewUtil;

public class DialogPermission extends BaseBindingDialogFragment<DialogPermissionBinding> {
    private ActivityResultLauncher<Intent> requestPermissionStorageSetting =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (SDK_INT >= Build.VERSION_CODES.R) {
                                if (Environment.isExternalStorageManager()) {

                                }
                            }
                        }
                    });

    @Override
    public int getLayoutId() {
        return R.layout.dialog_permission;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initView();
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                mainViewModel.liveEvent.postValue(new MessageEvent(GRANT_REQUEST_PERMISSION));
            }
        }
    }

    private void initListener() {
        binding.tvCancel.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            dismiss();
        });


        binding.tvGrant.setOnClickListener(v -> {
            ViewUtil.preventTwoClick(v, 500);
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s", requireContext().getPackageName())));
                requestPermissionStorageSetting.launch(intent);
            } catch (Exception e) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                requestPermissionStorageSetting.launch(intent);
            }
            dismiss();
        });
    }

    private void initView() {

    }

}
