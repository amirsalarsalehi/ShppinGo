package com.example.shoppingo.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SignUpViewModel extends AndroidViewModel {

    private static final String TAG = "SignUpViewModel";

    private MutableLiveData<Boolean> isUserNameValid;
    private MutableLiveData<Boolean> isEmailValid;

    @Inject
    public SignUpViewModel(@NonNull Application application) {
        super(application);
        Log.d("TAG", "SignUpViewModel: ");
        isUserNameValid = new MutableLiveData<>();
        isEmailValid = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getIsUserNameValid() {
        return isUserNameValid;
    }

    public MutableLiveData<Boolean> getIsEmailValid() {
        return isEmailValid;
    }
}
