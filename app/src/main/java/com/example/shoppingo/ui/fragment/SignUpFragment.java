package com.example.shoppingo.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.FragmentSignupBinding;
import com.example.shoppingo.di.base.BaseFragment;
import com.example.shoppingo.utils.AppKeys;
import com.example.shoppingo.utils.Utility;
import com.example.shoppingo.viewmodel.SignUpViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpFragment extends BaseFragment {

    private static final String TAG = "SignUpFragment";

    private FragmentSignupBinding binding;
    private SignUpViewModel viewModel;

    public SignUpFragment() {

    }

    @Override
    public void viewModel() {
        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
    }

    @Override
    public ViewDataBinding init(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        return binding;
    }

    @Override
    public void subscribeObservers() {
        viewModel.getIsUserNameValid().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    binding.signUpImgNameValidate.setImageResource(R.drawable.txtvalidate);
                    binding.signUpImgNameValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.signUpImgNameValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.signUpTxtNameValidateText.animate().scaleX(0f).scaleY(0f).setDuration(100);
                    binding.signUpTxtNameValidateText.setVisibility(View.GONE);
                } else {
                    binding.signUpImgNameValidate.setImageResource(R.drawable.notvalidate);
                    binding.signUpImgNameValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.signUpImgNameValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.signUpTxtNameValidateText.setText(String.format("%s is unavailable !", binding.signUpTIELName.getText().toString()));
                    binding.signUpTxtNameValidateText.setVisibility(View.VISIBLE);
                    binding.signUpTxtNameValidateText.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                }
            }
        });

        viewModel.getIsEmailNameValid().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    binding.signUpImgEmailValidate.setImageResource(R.drawable.txtvalidate);
                    binding.signUpImgEmailValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.signUpImgEmailValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.signUpTxtEmailValidateText.animate().scaleX(0f).scaleY(0f).setDuration(100);
                    binding.signUpTxtEmailValidateText.setVisibility(View.GONE);
                } else {
                    binding.signUpImgEmailValidate.setImageResource(R.drawable.notvalidate);
                    binding.signUpImgEmailValidate.animate().scaleX(0f).scaleY(0f).setDuration(0)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    binding.signUpImgEmailValidate
                                            .animate()
                                            .scaleY(1.0f)
                                            .scaleX(1.0f)
                                            .setDuration(100)
                                            .start();
                                }
                            }).start();
                    binding.signUpTxtEmailValidateText.setText(String.format("%s is not correct email !", binding.signUpTIELName.getText().toString()));
                    binding.signUpTxtEmailValidateText.setVisibility(View.VISIBLE);
                    binding.signUpTxtEmailValidateText.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                }
            }
        });
    }

    @Override
    public void initViews() {
        binding.signUpImgRedNextArrow.setOnClickListener(v ->
                NavHostFragment.findNavController(SignUpFragment.this)
                        .navigate(R.id.action_signUpFragment_to_loginFragment));

        binding.signUpTxtAlready.setOnClickListener(v ->
                NavHostFragment.findNavController(SignUpFragment.this)
                        .navigate(R.id.action_signUpFragment_to_loginFragment));

        binding.signUpTIELName.setOnFocusChangeListener((v, hasFocus) -> {
            if (!TextUtils.isEmpty(binding.signUpTIELName.getText())) {
                if (!hasFocus)
                    viewModel.getIsUserNameValid().setValue(
                            Utility.validate(AppKeys.USERNAME_REGEX, binding.signUpTIELName.getText().toString())
                    );
            }
        });

        binding.signUpTIELEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!TextUtils.isEmpty(binding.signUpTIELEmail.getText())) {
                    if (!hasFocus)
                        viewModel.getIsEmailNameValid().setValue(
                                Utility.validate(AppKeys.EMAIL_REGEX, binding.signUpTIELEmail.getText().toString())
                        );
                }
            }
        });
    }
}
