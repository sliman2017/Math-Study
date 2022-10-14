package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.YearsMenuAdapter;

public class Years extends AppCompatActivity {

    private String[] primarySchool, secondarySchool, highSchool;
    private CardView primaryCardView, secondaryCardView, highCardView;
    private RecyclerView primaryRecyclerView, secondaryRecyclerView, highRecyclerView;
    private LinearLayoutCompat primaryLinearLayout, secondaryLinearLayout, highLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initListeners();
        setUpYearsModels();
        fillRecyclerLevel(primaryRecyclerView, primarySchool);
        fillRecyclerLevel(secondaryRecyclerView, secondarySchool);
        fillRecyclerLevel(highRecyclerView, highSchool);
    }

    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    private void initViews(){
        setContentView(R.layout.activity_years);
        primaryCardView= (CardView) findViewById(R.id.primary_card);
        primaryLinearLayout = (LinearLayoutCompat) findViewById(R.id.primary_linearLayout);
        primaryRecyclerView = (RecyclerView) findViewById(R.id.primary_recycler);
        secondaryCardView = (CardView) findViewById(R.id.secondary_card);
        secondaryLinearLayout = (LinearLayoutCompat) findViewById(R.id.secondary_linearLayout);
        secondaryRecyclerView = (RecyclerView) findViewById(R.id.secondary_recycler);
        highCardView = (CardView) findViewById(R.id.high_card);
        highLinearLayout = (LinearLayoutCompat) findViewById(R.id.high_linearLayout);
        highRecyclerView = (RecyclerView) findViewById(R.id.high_recycler);
    }

    /**
     * this function will contain all the listeners in this activity
     */
    private void initListeners(){
        primaryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mv = (primaryRecyclerView.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(primaryLinearLayout, new AutoTransition());
                primaryRecyclerView.setVisibility(mv);
            }
        });
        secondaryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mv = (secondaryRecyclerView.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(secondaryLinearLayout, new AutoTransition());
                secondaryRecyclerView.setVisibility(mv);
            }
        });
        highCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mv = (highRecyclerView.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(highLinearLayout, new AutoTransition());
                highRecyclerView.setVisibility(mv);
            }
        });
    }

    /**
     * this function will fill the data_years from strings.xml ressource and put them in
     * the array variable that declared above.
     */
    public void setUpYearsModels(){
        primarySchool=  getResources().getStringArray(R.array.primary_school);
        secondarySchool = getResources().getStringArray(R.array.secondary_school);
        highSchool = getResources().getStringArray(R.array.high_school);
    }

    /**
     * this function will fill the recyclerView of level_cards in activity_years.xml layout.
     * it will attach our adapter to the recyclerView
     * @param level this means one of the three levels years in array of String.
     */
    public void fillRecyclerLevel(RecyclerView recyclerView, String[] level){
        YearsMenuAdapter adapter = new YearsMenuAdapter(level);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}