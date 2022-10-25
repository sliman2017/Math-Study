package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.OnboardingSliderAdapter;
import com.example.mathstudy.interfaces.ActivityInitializer;

/**
 * this activity is about the onBoarding screen that
 * use viewPager, adapter and layout_item.xml
 */
public class OnBoarding extends AppCompatActivity implements ActivityInitializer {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private Button letsGetStarted;
    private OnboardingSliderAdapter sliderAdapter;
    private Animation animation;
    private Button skipButton, nextButton;
    private int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN) ;

        initViews();
        initListeners();
        //call adapter
        sliderAdapter = new OnboardingSliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }


    /**
     * this function will add the four dots in the bottom of the
     * onBoarding screen that refers to current onBoarding page
     * note: page is one of onBoarding screen pages
     * @param position this parameter refers to the current position of onBoarding page
     */
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
            currentPos = position;
            switch (position){
                case 0:
                case 1:
                    letsGetStarted.setVisibility(View.INVISIBLE);
                    break;
                default:
                    animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.side_anim);
                    letsGetStarted.setAnimation(animation);
                    letsGetStarted.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void initViews() {
        setContentView(R.layout.activity_on_boarding);
        //hooks
        viewPager = (ViewPager) findViewById(R.id.slider);
        dotsLayout = (LinearLayout) findViewById(R.id.dots);
        letsGetStarted = (Button) findViewById(R.id.get_started_btn);
        skipButton = (Button) findViewById(R.id.skip_btn);
        nextButton = (Button) findViewById(R.id.next_btn);
    }

    @Override
    public void initListeners() {
        //listeners
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), OnBoardingSettings.class);
                startActivity(intent);
                finish();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPos + 1);
            }
        });
        letsGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoarding.this, OnBoardingSettings.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void initVars() {

    }

    @Override
    public void initFunctionality() {

    }
}