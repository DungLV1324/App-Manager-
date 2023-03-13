package com.example.filemanager.ui.main.main.setting.language;

import android.os.Bundle;
import android.view.View;

import com.example.filemanager.R;
import com.example.filemanager.databinding.FragmentLanguageBinding;
import com.example.filemanager.model.Language;
import com.example.filemanager.model.Recent;
import com.example.filemanager.ui.adapter.recycler.LanguageAdapter;
import com.example.filemanager.ui.adapter.recycler.RecentAdapter;
import com.example.filemanager.ui.base.BaseBindingFragment;

import java.util.LinkedList;
import java.util.List;

public class LanguageFragment extends BaseBindingFragment<FragmentLanguageBinding, LanguageViewModel> {
 private final List<Language> listLanguage=new LinkedList<>();
 private LanguageAdapter languageAdapter;


    @Override
    protected Class<LanguageViewModel> getViewModel() {
        return LanguageViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_language;
    }

    @Override
    protected void onCreatedView(View view, Bundle savedInstanceState) {
        initAdapter();
        initData();
    }

    public void initAdapter() {
        languageAdapter = new LanguageAdapter();
        binding.rcvLanguage.setAdapter(languageAdapter);
    }
    public void initData() {
        listLanguage.add(new Language("Tiếng Việt"));
        listLanguage.add(new Language("Tiếng Anh"));

        languageAdapter.setListLanguage(listLanguage);
    }
}
