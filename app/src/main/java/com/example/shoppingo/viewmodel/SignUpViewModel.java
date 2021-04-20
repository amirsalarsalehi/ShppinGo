package com.example.shoppingo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SignUpViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> isUserNameValid;
    private MutableLiveData<Boolean> isEmailNameValid;

    @Inject
    public SignUpViewModel(@NonNull Application application) {
        super(application);
        isUserNameValid = new MutableLiveData<>();
        isEmailNameValid = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getIsUserNameValid() {
        return isUserNameValid;
    }

    public MutableLiveData<Boolean> getIsEmailNameValid() {
        return isEmailNameValid;
    }
}
