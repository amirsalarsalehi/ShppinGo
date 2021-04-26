package com.example.shoppingo.ui.fragment.auth;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.FragmentLoginBinding;
import com.example.shoppingo.di.base.BaseFragment;
import com.example.shoppingo.utils.AppKeys;
import com.example.shoppingo.utils.Utility;
import com.example.shoppingo.viewmodel.LoginViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment {

    private FragmentLoginBinding binding;

    private LoginViewModel viewModel;

    public LoginFragment() {

    }

    @Override
    public void viewModel() {
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    public ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {
        viewModel.getIsEmailValid().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    binding.loginImgEmailValidate.setImageResource(R.drawable.txtvalidate);
                    binding.loginImgEmailValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.loginImgEmailValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.loginTxtEmailValidateText.animate().scaleX(0f).scaleY(0f).setDuration(100);
                    binding.loginTxtEmailValidateText.setVisibility(View.GONE);
                    binding.loginLinearCornerEmail.setBackground(null);
                } else {
                    binding.loginImgEmailValidate.setImageResource(R.drawable.notvalidate);
                    binding.loginImgEmailValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.loginImgEmailValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.loginTxtEmailValidateText.setText(String.format("%s is not correct email !", binding.loginTIELEmail.getText().toString()));
                    binding.loginTxtEmailValidateText.setVisibility(View.VISIBLE);
                    binding.loginTxtEmailValidateText.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                    binding.loginLinearCornerEmail.setBackgroundResource(R.drawable.linear_error_textinputlayout);
                }
            }
        });
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

        binding.loginTIELEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (!TextUtils.isEmpty(binding.loginTIELEmail.getText())) {
                if (!hasFocus)
                    viewModel.getIsEmailValid().setValue(
                            Utility.validate(AppKeys.EMAIL_REGEX, binding.loginTIELEmail.getText().toString())
                    );
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (inputCheckers()) {*/
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment());
                //}
            }
        });
    }

    private boolean inputCheckers() {
        return !TextUtils.isEmpty(binding.loginTIELEmail.getText().toString()) &&
                !TextUtils.isEmpty(binding.loginTIELPass.getText().toString());
    }
}