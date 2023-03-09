package com.example.filemanager.ui.main.home.home.document;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentDocumentBinding;
import com.example.filemanager.ui.base.BaseBindingFragment;

public class DocumentFragment extends BaseBindingFragment<FragmentDocumentBinding,DocumentViewModel> {
    @Override
    protected Class<DocumentViewModel> getViewModel() {
        return DocumentViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_document;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {

    }
}
