package com.example.covid3.ui.slideshow3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid3.R;

public class SlideshowFragment3 extends Fragment {

    private SlideshowViewModel3 slideshowViewModel3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel3 =
                ViewModelProviders.of(this).get(SlideshowViewModel3.class);
        View root = inflater.inflate(R.layout.fragment_slideshow3, container, false);
        final TextView textView3 = root.findViewById(R.id.text_slideshow3);
        slideshowViewModel3.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView3.setText(s);
            }
        });
        return root;
    }
}