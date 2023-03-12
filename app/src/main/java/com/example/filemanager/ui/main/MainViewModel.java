package com.example.filemanager.ui.main;

import com.example.filemanager.common.LiveEvent;
import com.example.filemanager.common.MessageEvent;
import com.example.filemanager.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends BaseViewModel {

    public LiveEvent<MessageEvent> liveEvent = new LiveEvent<>();

    @Inject
    public MainViewModel() {
    }
}
