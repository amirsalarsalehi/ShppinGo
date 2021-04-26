package com.example.shoppingo.ui.fragment.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.example.shoppingo.databinding.FragmentCategoriesBinding;
import com.example.shoppingo.di.base.BaseFragment;
import com.example.shoppingo.viewmodel.CategoriesViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoriesFragment extends BaseFragment {

    private FragmentCategoriesBinding binding;
    private CategoriesViewModel viewModel;

    public CategoriesFragment() {
        viewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
    }

    @Override
    public void viewModel() {

    }

    @Override
    public ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {

    }

    @Override
    public void initViews() {

    }
}