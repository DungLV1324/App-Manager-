package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemZipBinding;
import com.example.filemanager.model.Zip;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class ZipAdapter extends BaseBindingAdapter<ItemZipBinding> {
  List<Zip> listZip=new LinkedList<>();

    public void setListZip(List<Zip> listZip) {
        this.listZip.clear();
        this.listZip.addAll(listZip);
        notifyDataSetChanged();
    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_zip;
    }

    @Override
    public int sizeItem() {
        return listZip.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemZipBinding>.BaseHolder<ItemZipBinding> holder, int position) {
        holder.binding.tvName.setText(listZip.get(position).getNameZip());
        holder.binding.tvDate.setText(listZip.get(position).getDateZip());
    }
}
