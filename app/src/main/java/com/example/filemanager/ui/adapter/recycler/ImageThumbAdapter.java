package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemListImageThumbBindingImpl;
import com.example.filemanager.model.Image;
import com.example.filemanager.model.ImageThumb;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class ImageThumbAdapter extends BaseBindingAdapter<ItemListImageThumbBindingImpl> {

    List<ImageThumb> listImageThumb = new LinkedList<>();

    public void setListImageThumb(List<ImageThumb> listImageThumb) {
        this.listImageThumb = listImageThumb;
    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_list_image_thumb;
    }

    @Override
    public int sizeItem() {
        return listImageThumb.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemListImageThumbBindingImpl>.BaseHolder<ItemListImageThumbBindingImpl> holder, int position) {
        holder.binding.tvNameImage.setText(listImageThumb.get(position).getNameImageThumb());
    }
}
