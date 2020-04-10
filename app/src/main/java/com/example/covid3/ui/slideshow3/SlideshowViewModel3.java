package com.example.covid3.ui.slideshow3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel3 extends ViewModel {

    private MutableLiveData<String> mText1;

    public SlideshowViewModel3() {
        mText1 = new MutableLiveData<>();
        mText1.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText1;
    }
}