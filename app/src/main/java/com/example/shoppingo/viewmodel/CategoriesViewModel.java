package com.example.shoppingo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CategoriesViewModel extends AndroidViewModel {

    @Inject
    public CategoriesViewModel(@NonNull Application application) {
        super(application);
    }
    
}
