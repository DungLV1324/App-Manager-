package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemFavoriteBinding;
import com.example.filemanager.databinding.ItemFavorritThumbBinding;
import com.example.filemanager.model.Download;
import com.example.filemanager.model.Favorrite;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class FavoriteAdapter extends BaseBindingAdapter<ItemFavoriteBinding> {

    List<Favorrite> listItemFavorite =new LinkedList<>();
    public void setListItemFavorite(List<Favorrite> listItemFavorite) {
        this.listItemFavorite.clear();
        this.listItemFavorite.addAll(listItemFavorite);
        notifyDataSetChanged();    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_favorite;
    }

    @Override
    public int sizeItem() {
        return listItemFavorite.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemFavoriteBinding>.BaseHolder<ItemFavoriteBinding> holder, int position) {
        holder.binding.tvDate.setText(listItemFavorite.get(position).getDateItemFavorite());
        holder.binding.tvName.setText(listItemFavorite.get(position).getNameItemFavorite());
    }
}
