package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mathstudy.R;
import com.example.mathstudy.interfaces.ActivityInitializer;

public class Categories extends AppCompatActivity implements ActivityInitializer {

    private CardView lessonsCardView, exercicesCardView;
    private int mLevelID;
    SharedPreferences schoolSharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initListeners();
        schoolSharedPref= getSharedPreferences("schoolLevel", MODE_PRIVATE);
        mLevelID = schoolSharedPref.getInt("mySchoolLevel", 0 );
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_categories);
        lessonsCardView = (CardView) findViewById(R.id.lessons_cardView);
        exercicesCardView = (CardView) findViewById(R.id.exercices_cardView);
    }

    @Override
    public void initListeners() {
        lessonsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sectionIntent = new Intent(Categories.this, Sections.class);
                sectionIntent.putExtra("categorie_id", 6);
                startActivity(sectionIntent);
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

    @Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data
        // from the SharedPreference
        schoolSharedPref= getSharedPreferences("schoolLevel", MODE_PRIVATE);
        mLevelID = schoolSharedPref.getInt("mySchoolLevel", 0 );

    }
}