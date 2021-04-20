package com.example.shoppingo.ui.fragment;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.FragmentForgotPasswordBinding;
import com.example.shoppingo.di.base.BaseFragment;

public class ForgotPasswordFragment extends BaseFragment {

    FragmentForgotPasswordBinding binding;

    public ForgotPasswordFragment() {

    }

    @Override
    public void viewModel() {

    }

    @Override
    public ViewDataBinding init(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {

    }

    @Override
    public void initViews() {
        binding.forgotBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ForgotPasswordFragment.this)
                        .navigateUp();
            }
        });
    }
}