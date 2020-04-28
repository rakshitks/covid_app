package com.example.covid3.ui.slideshow4;

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

public class SlideshowFragment4 extends Fragment {

    private SlideshowViewModel4 slideshowViewModel4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel4 =
                ViewModelProviders.of(this).get(SlideshowViewModel4.class);
        View root = inflater.inflate(R.layout.fragment_slideshow4, container, false);
        final TextView textView4 = root.findViewById(R.id.text_slideshow4);
        slideshowViewModel4.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView4.setText(s);
            }
        });
        return root;
    }
}