package com.example.filemanager.ui.splash;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ActivitySplashBinding;
import com.example.filemanager.ui.base.BaseBindingActivity;
import com.example.filemanager.ui.main.home.MainActivity;

public class SplashActivity extends BaseBindingActivity<ActivitySplashBinding, SplashViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public Class<SplashViewModel> getViewModel() {
        return SplashViewModel.class;
    }

    @Override
    public void setupView(Bundle savedInstanceState) {


        binding.animationView1.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startMainActivity();
            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void setupData() {

    }
}
