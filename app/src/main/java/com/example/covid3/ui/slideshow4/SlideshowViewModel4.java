package com.example.covid3.ui.slideshow4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel4 extends ViewModel {

    private MutableLiveData<String> mText4;

    public SlideshowViewModel4() {
        mText4 = new MutableLiveData<>();
        mText4.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText4;
    }
}