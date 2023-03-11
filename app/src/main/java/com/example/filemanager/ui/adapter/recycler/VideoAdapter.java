package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemVideoBinding;
import com.example.filemanager.model.Video;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class VideoAdapter extends BaseBindingAdapter<ItemVideoBinding> {
  List<Video> listVideo=new LinkedList<>();
    @Override
    public int layoutIdItem() {
        return R.layout.item_image;
    }

    @Override
    public int sizeItem() {
        return listVideo.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemVideoBinding>.BaseHolder<ItemVideoBinding> holder, int position) {
        holder.binding.tvName.setText(listVideo.get(position).getNameVideo());
        holder.binding.tvDate.setText(listVideo.get(position).getDateVideo());
    }
}
