package com.example.mathstudy.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.LessonsMenuAdapter;
import com.example.mathstudy.adapters.SectionsMenuAdapter;
import com.example.mathstudy.interfaces.ItemClickListener;
import com.example.mathstudy.roomComponents.entities.Lesson;
import com.example.mathstudy.roomComponents.entities.Section;
import com.example.mathstudy.viewModel.DocumentViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * this class it's an activity that show the all Sections for specific years
 *
 */
public class Sections extends AppCompatActivity {

    private ArrayList<Section> mSections = new ArrayList<>();
    private ArrayList<Lesson> mLessons = new ArrayList<>();
    private RecyclerView sectionRecycler;
    private ItemClickListener itemClickListener;
    private int mSchoolLevel;
    private int mCategorie;
    private DocumentViewModel documentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initListeners();
        dataReceiver();
        // Fixme: i used the data placeholder to test the app, i have to change it when check that is work.
        mSections.addAll(getmSections(1));
        Log.v("lessonsSize: ", " "+mLessons.size());
        setUpDocsModels();
        fillRecyclerSections(sectionRecycler, mSections);
    }


    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    private void initViews() {
        setContentView(R.layout.activity_sections);
        documentViewModel = new DocumentViewModel(getApplication());
        sectionRecycler = (RecyclerView) findViewById(R.id.section_recycler);
    }

    /**
     * this function will contain all the listeners in this activity
     */
    private void initListeners(){
    }

    /**
     * this function will fill the Sections data from database resource and put them in
     * the arrayList<Section> variable that declared above.
     */
    private void setUpDocsModels() {
        mSections.add(new Section(1,1,"The equations", "More than 30 exercices"));
        mSections.add(new Section(2,2,"The calculus", "50 exercices with solutions"));
        mSections.add(new Section(3,3,"Algebric", "Tasks without solutions"));
        mSections.add(new Section(4,4,"Quadratique equations", "No exercices exist"));
        mSections.add(new Section(5,5,"Geometricue", "More than 4 exercices"));

        mLessons.add(new Lesson(7, 1, "title lesson  01", "subTitle lessons 01"));
        mLessons.add(new Lesson(8, 2, "title lesson  02", "subTitle lessons 02"));
        mLessons.add(new Lesson(9, 1, "title lesson  03", "subTitle lessons 03"));
        mLessons.add(new Lesson(10, 2, "title lesson  04", "subTitle lessons 04"));
        mLessons.add(new Lesson(11, 3, "title lesson  05", "subTitle lessons 05"));
    }

    /**
     * this function will attach the adapter to the recyclerView
     * @param recyclerView this parameter will be the one of these three
     *                     recycler sectionRecycler, t2Recycler or t3Recycler.
     *                     with t means trimester.
     * @param section will be the list of Sections for the trimester_1, trimester_2
     *                  or trimester_3 in the chosen Categorie.
     */
    public void fillRecyclerSections(RecyclerView recyclerView, ArrayList<Section> section){
        SectionsMenuAdapter adapter = new SectionsMenuAdapter(section);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * this function will receive the data which is (Level and Year) from sharedPreferences
     * and the Intent coming from categories which is (Categorie type)
     */
    public void dataReceiver(){
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            mCategorie = extras.getInt("lessons");
        }
        SharedPreferences schoolLevel = getSharedPreferences("schoolLevel", MODE_PRIVATE);
        mSchoolLevel = schoolLevel.getInt("mySchoolLevel", 0);

    }

    public ArrayList<Section> getmSections(int idYear){
        List<Section> sectionsList = documentViewModel.getmeSections(idYear);
        ArrayList<Section> mSectionArrayList = new ArrayList<>();
        mSectionArrayList.addAll(sectionsList);
        return mSectionArrayList;
    }

}