package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.OnboardingSliderAdapter;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dots;
    OnboardingSliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        //hooks
        viewPager = (ViewPager) findViewById(R.id.slider);
        dotsLayout = (LinearLayout) findViewById(R.id.dots);
        //call adapter
        sliderAdapter = new OnboardingSliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addDots (int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();
        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView( this);
            dots[i].setText (Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.orange));
        }
    }
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}