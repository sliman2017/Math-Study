package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Switch;

import com.example.mathstudy.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this activity is the one that contains the level and year that
 * the user need to select using the SharedPreferences Data Storage
 * option and it will open only in the first time
 */
public class OnBoardingSettings extends AppCompatActivity {

    private String[] levels, years;
    private String mLevel, mYear;
    private AutoCompleteTextView autoCompleteTextViewLevel, autoCompleteTextViewYear;
    private AppCompatButton getStarted;
    private SharedPreferences schoolLevelSharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initListeners();
        setUpLevelsModels();
        fillDropDownMenu(autoCompleteTextViewLevel, levels);
    }


    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    private void initViews() {
        setContentView(R.layout.activity_onboarding_settings);
        getStarted = (AppCompatButton) findViewById(R.id.get_startedBtn_settings);
        autoCompleteTextViewLevel = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_level);
        autoCompleteTextViewYear = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_Year);
    }
    /**
     * this function will contain all the listeners in this activity
     */
    private void initListeners() {
        autoCompleteTextViewLevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autoCompleteTextViewYear.setText("Year");

                // the next lines of code will fill the years array with data from strings.xml
                // according the value of mLevel which is (primary_school, secondary_school or high_school)
                mLevel = parent.getItemAtPosition(position).toString();
                switch (mLevel){
                    case "Secondary School":
                        years = getResources().getStringArray(R.array.secondary_school);
                        break;
                    case "High School":
                        years = getResources().getStringArray(R.array.high_school);
                        break;
                    default:
                        years = getResources().getStringArray(R.array.primary_school);
                }
                fillDropDownMenu(autoCompleteTextViewYear, years);
            }
        });
        autoCompleteTextViewYear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mYear = parent.getItemAtPosition(position).toString();
            }
        });
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this line of codes will save the level and year chosen in sharedPreference file
                schoolLevelSharedPref = getSharedPreferences("schoolLevel", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = schoolLevelSharedPref.edit();
                myEdit.putInt("mySchoolLevel", getSchoolLevel(mLevel, mYear));
                myEdit.commit();
                Log.v("from settings", "the level is: "+getSchoolLevel(mLevel, mYear));
                //this lines will open Categorie.class and close the current one.
                Intent intent = new Intent(OnBoardingSettings.this, Categories.class);
                startActivity(intent);
                finish();
            }
        });
    }


    /**
     * this function will get the list of words of levels and years and put them
     * in array of string to use later in this class.
     */
    public void setUpLevelsModels(){
        levels = getResources().getStringArray(R.array.level);
    }
    /**
     * this function will attach the autoCompleteTextView with the ArrayAdapter
     * which means it will connect the list of word and text_item.xml and the dropdown_menu.
     * @param autoCompleteTextView this is for the specified dropdown_menu
     * @param menuWords this is the list of word that we will put in the dropdown_menu
     */
    public void fillDropDownMenu(AutoCompleteTextView autoCompleteTextView, String[] menuWords){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.firstpage_item, R.id.textItem, menuWords);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }

    /**
     * this function will return the database string of schoolLevel after concatenate level string
     * and the year string.
     * @param level
     * @param year
     * @return the schoolLevel in string datatype.
     */
    public int getSchoolLevel(String level, String year){
        int schoolLevel;
        if (level == "Primary School") {
            switch (year){
                case "First Year":
                    schoolLevel = 1;
                    break;
                case "Second Year":
                    schoolLevel = 2;
                    break;
                case "Third Year":
                    schoolLevel = 3;
                    break;
                case "Fourth Year":
                    schoolLevel = 4;
                    break;
                case "Fifth Year":
                    schoolLevel = 5;
                    break;
                case "Six Year":
                    schoolLevel = 6;
                    break;
                default:
                    schoolLevel = 1;

            }
        }else if (level == "Secondary School") {
            switch (year){
                case "First Year":
                    schoolLevel = 7;
                    break;
                case "Second Year":
                    schoolLevel = 8;
                    break;
                case "Third Year":
                    schoolLevel = 9;
                    break;
                default:
                    schoolLevel = 7;
            }
        }else{
            switch (year){
                case "First Year":
                    schoolLevel = 10;
                    break;
                case "Second Year":
                    schoolLevel = 11;
                    break;
                case "Third Year":
                    schoolLevel = 12;
                    break;
                default:
                    schoolLevel = 10;
            }
        }
        return schoolLevel;
    }

}