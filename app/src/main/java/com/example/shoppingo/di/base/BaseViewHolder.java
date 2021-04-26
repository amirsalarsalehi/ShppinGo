package com.example.shoppingo.di.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull ViewDataBinding itemView) {
        super(itemView.getRoot());
    }

    public abstract void setBindingData(T t);

    public abstract void bind();

    public abstract void unbind();

}
