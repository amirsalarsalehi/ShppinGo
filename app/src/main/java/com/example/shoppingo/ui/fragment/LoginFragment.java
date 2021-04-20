package com.example.shoppingo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.FragmentLoginBinding;
import com.example.shoppingo.di.base.BaseFragment;

public class LoginFragment extends BaseFragment {

    private FragmentLoginBinding binding;

    public LoginFragment() {

    }

    @Override
    public void viewModel() {

    }

    @Override
    public ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {

    }

    @Override
    public void initViews() {
        binding.loginImgRedNextArrow.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_forgotPasswordFragment));

        binding.loginTxtForgotPass.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_forgotPasswordFragment));

        binding.loginBtnBack.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigateUp());
    }
}