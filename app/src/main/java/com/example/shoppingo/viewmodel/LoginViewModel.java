package com.example.shoppingo.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends AndroidViewModel {

    private static final String TAG = "LoginViewModel";

    private MutableLiveData<Boolean> isEmailValid;

    @Inject
    public LoginViewModel(@NonNull Application application) {
        super(application);
        isEmailValid = new MutableLiveData<>();
        Log.d("TAG", "LoginViewModel: ");
    }

    public MutableLiveData<Boolean> getIsEmailValid() {
        return isEmailValid;
    }
}
