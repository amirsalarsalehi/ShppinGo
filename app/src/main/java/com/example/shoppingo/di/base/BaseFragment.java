package com.example.shoppingo.di.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.shoppingo.ui.MainActivity;

public abstract class BaseFragment extends Fragment {

    public abstract void viewModel();

    public abstract ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public abstract void subscribeObservers();

    public abstract void initViews();

    private View viewRoot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewRoot == null) {
            viewRoot = init(inflater, container, savedInstanceState).getRoot();
            viewModel();
            subscribeObservers();
        }
        initViews();
        return viewRoot;
    }
}
