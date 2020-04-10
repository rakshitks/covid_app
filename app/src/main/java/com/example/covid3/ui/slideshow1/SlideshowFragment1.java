package com.example.covid3.ui.slideshow1;

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

public class SlideshowFragment1 extends Fragment {

    private SlideshowViewModel1 slideshowViewModel1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel1 =
                ViewModelProviders.of(this).get(SlideshowViewModel1.class);
        View root = inflater.inflate(R.layout.fragment_slideshow1, container, false);
        final TextView textView1 = root.findViewById(R.id.text_slideshow1);
        slideshowViewModel1.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView1.setText(s);
            }
        });
        return root;
    }
}