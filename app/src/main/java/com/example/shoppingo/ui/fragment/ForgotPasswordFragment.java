package com.example.shoppingo.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.FragmentForgotPasswordBinding;
import com.example.shoppingo.di.base.BaseFragment;
import com.example.shoppingo.utils.AppKeys;
import com.example.shoppingo.utils.Utility;
import com.example.shoppingo.viewmodel.ForgotPasswordViewModel;
import com.google.android.material.internal.TextWatcherAdapter;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ForgotPasswordFragment extends BaseFragment {

    private FragmentForgotPasswordBinding binding;
    private ForgotPasswordViewModel viewModel;

    public ForgotPasswordFragment() {

    }

    @Override
    public void viewModel() {
        viewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);
    }

    @Override
    public ViewDataBinding init(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {
        viewModel.getIsEmailValid().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    binding.forgotImgEmailValidate.setImageResource(R.drawable.txtvalidate);
                    binding.forgotImgEmailValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.forgotImgEmailValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.forgotTxtEmailValidateText.animate().scaleX(0f).scaleY(0f).setDuration(100);
                    binding.forgotTxtEmailValidateText.setVisibility(View.GONE);
                } else {
                    binding.forgotImgEmailValidate.setImageResource(R.drawable.notvalidate);
                    binding.forgotImgEmailValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.forgotImgEmailValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.forgotTxtEmailValidateText.setText(String.format("%s is not correct email !", binding.forgotTIELEmail.getText().toString()));
                    binding.forgotTxtEmailValidateText.setVisibility(View.VISIBLE);
                    binding.forgotTxtEmailValidateText.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                }
            }
        });
    }

    @Override
    public void initViews() {
        binding.forgotBtnBack.setOnClickListener(v -> NavHostFragment.findNavController(ForgotPasswordFragment.this)
                .navigateUp());

        binding.forgotTIELEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(binding.forgotTIELEmail.getText())) {
                    viewModel.getIsEmailValid().setValue(
                            Utility.validate(AppKeys.EMAIL_REGEX, binding.forgotTIELEmail.getText().toString())
                    );
                }
            }
        });
    }
}