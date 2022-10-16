package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.mathstudy.R;

public class FirstPage extends AppCompatActivity {

    private String[] levels;
    private AutoCompleteTextView autoCompleteTextViewLevel, autoCompleteTextViewYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        levels = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> arrayAdapterLevel = new ArrayAdapter<String>(this,
                R.layout.firstpage_item, R.id.textItem, levels);
        autoCompleteTextViewLevel = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_level);
        autoCompleteTextViewLevel.setAdapter(arrayAdapterLevel);
    }
}