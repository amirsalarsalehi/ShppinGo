package com.example.shoppingo.ui.fragment.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingo.databinding.FragmentMainBinding;
import com.example.shoppingo.di.base.BaseFragment;
import com.example.shoppingo.ui.recycler.adapter.MainStaggeredAdapter;
import com.example.shoppingo.utils.SpannedGridLayoutManager;
import com.example.shoppingo.utils.SpannedGridLayoutManager.SpanInfo;
import com.example.shoppingo.viewmodel.MainFragmentViewModel;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends BaseFragment implements MainStaggeredAdapter.OnStaggeredClick {

    private static final String TAG = "MainFragment";

    private FragmentMainBinding binding;
    private MainFragmentViewModel viewModel;
    private MainStaggeredAdapter adapter;

    public MainFragment() {
    }

    @Override
    public void viewModel() {
        viewModel = new ViewModelProvider(this).get(MainFragmentViewModel.class);

        adapter = new MainStaggeredAdapter(MainFragment.this);
        binding.mainFragmentRv.setAdapter(adapter);
        SpannedGridLayoutManager sglm = new SpannedGridLayoutManager(position -> {
            if (position % 6 == 0)
                return new SpanInfo(5, 3);
            else if (position % 6 == 1)
                return new SpanInfo(1, 1);
            else if (position % 6 == 2)
                return new SpanInfo(2, 3);
            else
                return new SpanInfo(1, 1);
        }, 3, 1f);
        binding.mainFragmentRv.setLayoutManager(sglm);
    }

    @Override
    public ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {
        viewModel.getImgUrlsLiveData().observe(getViewLifecycleOwner(), strings -> {
            adapter.setImgUrls(strings);
        });
    }

    @Override
    public void initViews() {
        List<String> list = new ArrayList<>();
        list.add("catimg");
        list.add("bigbannermainpage");
        list.add("catimg3");
        list.add("catimg4");
        viewModel.getImgUrlsLiveData().setValue(list);
    }

    @Override
    public void onStaggeredClick(String fashionName) {
        NavHostFragment.findNavController(MainFragment.this)
                .navigate(MainFragmentDirections.actionMainFragmentToSelectedFashionFragment());
    }
}