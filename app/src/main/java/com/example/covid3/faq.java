package com.example.covid3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class faq extends AppCompatActivity {
    PDFView pdfView_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        setTitle("FAQs on coronovirus");
        pdfView_1=findViewById(R.id.pdfView1);
        pdfView_1.fromAsset("FAQ.pdf").load();
    }
}
