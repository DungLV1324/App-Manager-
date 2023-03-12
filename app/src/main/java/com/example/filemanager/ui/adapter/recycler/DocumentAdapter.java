package com.example.filemanager.ui.adapter.recycler;

import androidx.annotation.NonNull;

import com.example.filemanager.R;
import com.example.filemanager.databinding.ItemApkBinding;
import com.example.filemanager.databinding.ItemDocumentBinding;
import com.example.filemanager.model.Document;
import com.example.filemanager.ui.base.BaseBindingAdapter;

import java.util.LinkedList;
import java.util.List;

public class DocumentAdapter extends BaseBindingAdapter<ItemDocumentBinding> {
  List<Document> listDocument=new LinkedList<>();

    public void setListDocument(List<Document> listDocument) {
        this.listDocument.clear();
        this.listDocument.addAll(listDocument);
        notifyDataSetChanged();    }

    @Override
    public int layoutIdItem() {
        return R.layout.item_document;
    }

    @Override
    public int sizeItem() {
        return listDocument.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingAdapter<ItemDocumentBinding>.BaseHolder<ItemDocumentBinding> holder, int position) {
        holder.binding.tvName.setText(listDocument.get(position).getNameDocument());
        holder.binding.tvDate.setText(listDocument.get(position).getDateDocument());
    }
}
