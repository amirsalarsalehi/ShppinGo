package com.example.shoppingo.ui.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingo.R;
import com.example.shoppingo.ui.recycler.viewholder.MainStaggeredViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainStaggeredAdapter extends RecyclerView.Adapter<MainStaggeredViewHolder> {

    private List<String> imgUrls = new ArrayList<>();
    private LayoutInflater inflate;
    private OnStaggeredClick onStaggeredClick;

    public MainStaggeredAdapter(OnStaggeredClick onStaggeredClick) {
        this.onStaggeredClick = onStaggeredClick;
    }

    @NonNull
    @Override
    public MainStaggeredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflate == null)
            inflate = LayoutInflater.from(parent.getContext());

        return new MainStaggeredViewHolder(
                DataBindingUtil.inflate(inflate, R.layout.item_main_cat, parent, false), onStaggeredClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MainStaggeredViewHolder holder, int position) {
        holder.setBindingData(imgUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return imgUrls.size();
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
        notifyDataSetChanged();
    }

    public interface OnStaggeredClick {
        void onStaggeredClick(String fashionName);
    }

}
