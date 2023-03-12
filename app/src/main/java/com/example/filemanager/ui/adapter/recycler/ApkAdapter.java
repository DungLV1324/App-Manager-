package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemApkBinding;
import com.example.filemanager.model.Apk;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class ApkAdapter extends BaseBindingAdapter<ItemApkBinding> {
  List<Apk> listApk=new LinkedList<>();

    public void setListApk(List<Apk> listApk) {
        this.listApk.clear();
        this.listApk.addAll(listApk);
        notifyDataSetChanged();    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_apk;
    }

    @Override
    public int sizeItem() {
        return listApk.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemApkBinding>.BaseHolder<ItemApkBinding> holder, int position) {
        holder.binding.tvName.setText(listApk.get(position).getNameApk());
        holder.binding.tvDate.setText(listApk.get(position).getDateApk());
    }
}
