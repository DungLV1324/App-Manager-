package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemMusicBinding;
import com.example.filemanager.databinding.ItemRecentBinding;
import com.example.filemanager.model.Music;
import com.example.filemanager.model.Recent;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class RecentAdapter extends BaseBindingAdapter<ItemRecentBinding> {
    List<Recent> listItemRecent =new LinkedList<>();

    public void setListItemRecent(List<Recent> listItemRecent) {
        this.listItemRecent.clear();
        this.listItemRecent.addAll(listItemRecent);
        notifyDataSetChanged();     }

    @Override
    public int layoutIdItem() {
        return R.layout.item_recent;
    }

    @Override
    public int sizeItem() {
        return listItemRecent.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemRecentBinding>.BaseHolder<ItemRecentBinding> holder, int position) {
        holder.binding.tvName.setText(listItemRecent.get(position).getNameItemRecent());
        holder.binding.tvDate.setText(listItemRecent.get(position).getDateItemRecent());
    }
}
