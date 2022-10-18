package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.OnboardingSliderAdapter;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dots;
    OnboardingSliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        //hooks
        viewPager = (ViewPager) findViewById(R.id.slider);
        dots = (LinearLayout) findViewById(R.id.dots);
        //call adapter
        sliderAdapter = new OnboardingSliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
    }
}