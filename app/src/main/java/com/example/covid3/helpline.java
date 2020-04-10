package com.example.covid3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class helpline extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
        setTitle("Helpline");
        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("coronhelpline.pdf").load();
    }
}
