package com.example.shoppingo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ForgotPasswordViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> isEmailValid;

    @Inject
    public ForgotPasswordViewModel(@NonNull Application application) {
        super(application);
        isEmailValid = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getIsEmailValid() {
        return isEmailValid;
    }
}
