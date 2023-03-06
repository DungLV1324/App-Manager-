package com.example.filemanager.ui.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseBindingAdapter<B extends ViewDataBinding> extends RecyclerView.Adapter<BaseBindingAdapter<B>.BaseHolder<B>> {
    public abstract int layoutIdItem();

    public abstract int sizeItem();


    @NonNull
    @Override
    public BaseHolder<B> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutIdItem(), parent, false);
        return new BaseHolder<>(binding);
    }

    @Override
    public int getItemCount() {
        return sizeItem();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder<B> holder, int position) {

    }

    public class BaseHolder<A extends ViewDataBinding> extends RecyclerView.ViewHolder {
        public A binding;

        public BaseHolder(@NonNull A binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
