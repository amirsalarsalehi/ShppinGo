package com.example.shoppingo.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.example.shoppingo.R;
import com.example.shoppingo.ui.recycler.adapter.MainStaggeredAdapter;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> imgUrlsLiveData;

    @Inject
    public MainFragmentViewModel(@NonNull Application application) {
        super(application);
        imgUrlsLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<String>> getImgUrlsLiveData() {
        return imgUrlsLiveData;
    }

    @BindingAdapter("imageSource")
    public static void imageSource(ImageView img, String source) {
        if (source.startsWith("http") || source.startsWith("https")) {
            Glide.with(img.getContext())
                    .load(source)
                    .into(img);
        } else {
            Glide.with(img.getContext())
                    .load(
                            img.getContext()
                                    .getResources()
                                    .getIdentifier(source, "drawable", img.getContext().getPackageName())
                    )
                    .into(img);
        }
    }
}
