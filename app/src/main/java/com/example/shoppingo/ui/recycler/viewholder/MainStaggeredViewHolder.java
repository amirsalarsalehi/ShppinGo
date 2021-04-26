package com.example.shoppingo.ui.recycler.viewholder;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.shoppingo.databinding.ItemMainCatBinding;
import com.example.shoppingo.di.base.BaseViewHolder;
import com.example.shoppingo.ui.recycler.adapter.MainStaggeredAdapter;

public class MainStaggeredViewHolder extends BaseViewHolder<String> {

    private ItemMainCatBinding itemView;
    private MainStaggeredAdapter.OnStaggeredClick onStaggeredClick;

    public MainStaggeredViewHolder(@NonNull ItemMainCatBinding itemView, MainStaggeredAdapter.OnStaggeredClick onStaggeredClick) {
        super(itemView);
        this.itemView = itemView;
        this.onStaggeredClick = onStaggeredClick;
    }

    @Override
    public void setBindingData(String str) {
        itemView.setData(str);
        itemView.itemMainCategoryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStaggeredClick.onStaggeredClick(str);
            }
        });
    }

    @Override
    public void bind() {
        itemView.executePendingBindings();
    }

    @Override
    public void unbind() {
        itemView.unbind();
    }
}
