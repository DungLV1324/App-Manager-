package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemApkBinding;
import com.example.filemanager.databinding.ItemMusicBinding;
import com.example.filemanager.model.Music;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class MusicAdapter extends BaseBindingAdapter<ItemMusicBinding> {
  List<Music> listMusic=new LinkedList<>();

    public void setListMusic(List<Music> listMusic) {
        this.listMusic.clear();
        this.listMusic.addAll(listMusic);
        notifyDataSetChanged();    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_music;
    }

    @Override
    public int sizeItem() {
        return listMusic.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemMusicBinding>.BaseHolder<ItemMusicBinding> holder, int position) {
        holder.binding.tvName.setText(listMusic.get(position).getNameMusic());
        holder.binding.tvDate.setText(listMusic.get(position).getDateMusic());
    }
}
