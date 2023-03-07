package com.example.filemanager.ui.adapter;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemImageBinding;
import com.example.filemanager.modle.Image;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class ImageAdapter extends BaseBindingAdapter<ItemImageBinding> {
    List<Image> listImage = new LinkedList<>();

    public void setListImage(List<Image> listImage) {
        this.listImage.clear();
        this.listImage.addAll(listImage);
        notifyDataSetChanged();
    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_image;
    }

    @Override
    public int sizeItem() {
        return listImage.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemImageBinding>.BaseHolder<ItemImageBinding> holder, int position) {
        holder.binding.tvName.setText(listImage.get(position).getNameImage());
        holder.binding.tvDate.setText(listImage.get(position).getDateImage());
    }

}
