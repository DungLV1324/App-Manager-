package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemListVideoThumbBinding;
import com.example.filemanager.model.Video;
import com.example.filemanager.model.VideoThumb;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class VideoThumbAdapter extends BaseBindingAdapter<ItemListVideoThumbBinding> {

    List<VideoThumb> listVideoThumb = new LinkedList<>();

    public void setListVideoThumb(List<VideoThumb> listVideoThumb) {
        this.listVideoThumb = listVideoThumb;
    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_list_video_thumb;
    }

    @Override
    public int sizeItem() {
        return listVideoThumb.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemListVideoThumbBinding>.BaseHolder<ItemListVideoThumbBinding> holder, int position) {
        holder.binding.tvNameVideo.setText(listVideoThumb.get(position).getNameItemThumb());
    }
}
