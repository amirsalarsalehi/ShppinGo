package com.example.shoppingo.ui.fragment.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.ViewDataBinding;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.FragmentMainPageBinding;
import com.example.shoppingo.di.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainPageFragment extends BaseFragment {

    private FragmentMainPageBinding binding;

    public MainPageFragment() {
    }

    @Override
    public void viewModel() {

    }

    @Override
    public ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        binding.collapsingToolbar.setExpandedTitleTypeface(ResourcesCompat.getFont(requireContext(), R.font.bold));
        return binding;
    }

    @Override
    public void subscribeObservers() {

    }

    @Override
    public void initViews() {
    }
}