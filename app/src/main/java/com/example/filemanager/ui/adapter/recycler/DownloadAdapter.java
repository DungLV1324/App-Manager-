package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemApkBinding;
import com.example.filemanager.databinding.ItemDownloadBinding;
import com.example.filemanager.model.Apk;
import com.example.filemanager.model.Download;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class DownloadAdapter extends BaseBindingAdapter<ItemDownloadBinding> {
  List<Download> listDownload=new LinkedList<>();

    public void setListDownload(List<Download> listDownload) {
        this.listDownload.clear();
        this.listDownload.addAll(listDownload);
        notifyDataSetChanged();    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_download;
    }

    @Override
    public int sizeItem() {
        return listDownload.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemDownloadBinding>.BaseHolder<ItemDownloadBinding> holder, int position) {
        holder.binding.tvName.setText(listDownload.get(position).getNameDownload());
        holder.binding.tvDate.setText(listDownload.get(position).getDateDownload());
    }
}
