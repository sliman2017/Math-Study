package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mathstudy.R;
import com.github.barteksc.pdfviewer.PDFView;


    // TODO 01: create this pdf_reader
    // TODO 02: read pdf from local phone by clicking specific button
    // TODO 03: add data placeholder to the database
    // TODO 04: connect the four activity and pass data between them
    // TODO 05: add the functionality of download document by clicking on document item
    // TODO 06: open the file directly after download it
    // TODO 07: fill the database with real data
    // FIXME 08: make some change to design

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