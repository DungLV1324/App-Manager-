package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemMusicBinding;
import com.example.filemanager.databinding.LanguageBinding;
import com.example.filemanager.model.Language;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.ArrayList;
import java.util.List;

public class LanguageAdapter extends BaseBindingAdapter<LanguageBinding> {
    List<Language> listLanguage = new ArrayList<>();

    public void setListLanguage(List<Language> listLanguage) {
        this.listLanguage.clear();
        this.listLanguage.addAll(listLanguage);
        notifyDataSetChanged();

    }


    @Override
    public int layoutIdItem() {
        return R.layout.language;
    }

    @Override
    public int sizeItem() {
        return listLanguage.size();
    }
    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<LanguageBinding>.BaseHolder<LanguageBinding> holder, int position) {
        holder.binding.tvVietnamese.setText(listLanguage.get(position).getNameLanguage());

    }
}
