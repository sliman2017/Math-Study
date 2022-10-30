package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mathstudy.R;
import com.github.barteksc.pdfviewer.PDFView;


    // TODO 06: add the functionality of download document by clicking on document item
    // TODO 07: open the file directly after download it
    // TODO 08: fill the database with real data
    // TODO 09: add navigation drawer to categories activity
    // FIXME 09: make some change to design
    // FIXME 10: create interface for initViews, initVar, initListener and implement it in the classes

/**
 * this activity read the files with format pdf using "barteksc_pdf_viewer".
 */
public class PdfReader extends AppCompatActivity {

    PDFView pdfViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);
        pdfViewer = (PDFView) findViewById(R.id.pdfViewer);
        pdfViewer.fromAsset("math_level1.pdf").load();
    }



}