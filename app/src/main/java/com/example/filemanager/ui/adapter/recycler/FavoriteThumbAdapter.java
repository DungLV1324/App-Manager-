package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemFavorritThumbBinding;
import com.example.filemanager.model.FavoriteThumb;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class FavoriteThumbAdapter extends BaseBindingAdapter<ItemFavorritThumbBinding> {

    List<FavoriteThumb> listItemThumb = new LinkedList<>();

    public void setListItemThumb(List<FavoriteThumb> listItemThumb) {
        this.listItemThumb.clear();
        this.listItemThumb.addAll(listItemThumb);
        notifyDataSetChanged();
    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_favorrit_thumb;
    }

    @Override
    public int sizeItem() {
        return listItemThumb.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemFavorritThumbBinding>.BaseHolder<ItemFavorritThumbBinding> holder, int position) {
        holder.binding.tvNameImage.setText(listItemThumb.get(position).getNameItemFavorite());
    }
}
