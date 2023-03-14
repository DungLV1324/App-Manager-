package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemListZipThumbBinding;
import com.example.filemanager.model.ZipThumb;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class ZipThumbAdapter extends BaseBindingAdapter<ItemListZipThumbBinding> {

    List<ZipThumb> listZipThumb = new LinkedList<>();

    public void setListZipThumb(List<ZipThumb> listZipThumb) {
        this.listZipThumb = listZipThumb;
    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_list_zip_thumb;
    }

    @Override
    public int sizeItem() {
        return listZipThumb.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemListZipThumbBinding>.BaseHolder<ItemListZipThumbBinding> holder, int position) {
        holder.binding.tvNameZip.setText(listZipThumb.get(position).getNameItemThumb());
    }
}
