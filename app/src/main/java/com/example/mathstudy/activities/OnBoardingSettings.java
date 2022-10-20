package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.YearsMenuAdapter;

public class OnBoardingSettings extends AppCompatActivity {

    private String[] levels, years;
    private AutoCompleteTextView autoCompleteTextViewLevel, autoCompleteTextViewYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initListeners();
        setUpLevelsModels();
        fillDropDownMenu(autoCompleteTextViewLevel, levels);
    }



    private void initViews() {
        setContentView(R.layout.activity_first_page);
        autoCompleteTextViewLevel = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_level);
        autoCompleteTextViewYear = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_Year);
    }

    private void initListeners() {
        autoCompleteTextViewLevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autoCompleteTextViewYear.setText("Year");
                String mLevel = parent.getItemAtPosition(position).toString();
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

}