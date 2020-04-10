package com.example.covid3.ui.slideshow2;

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

public class SlideshowFragment2 extends Fragment {

    private SlideshowViewModel2 slideshowViewModel2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel2 =
                ViewModelProviders.of(this).get(SlideshowViewModel2.class);
        View root = inflater.inflate(R.layout.fragment_slideshow2, container, false);
        final TextView textView2 = root.findViewById(R.id.text_slideshow2);
        slideshowViewModel2.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView2.setText(s);
            }
        });
        return root;
    }
}