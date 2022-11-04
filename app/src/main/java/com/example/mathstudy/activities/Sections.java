package com.example.mathstudy.activities;

import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathstudy.R;
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
        // TODO: retrieve images from sqlite room database and put in the next line
        mSections.addAll(getAllSectionsAndLessons(1, 1).getSectionList());
        mLessons.addAll(getAllSectionsAndLessons(1,1).getLessonList());
        setUpDocsModels();
        fillRecyclerSections(sectionRecycler, mSections, mLessons);
    }


    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    private void initViews() {
        setContentView(R.layout.activity_sections);
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
    public void fillRecyclerSections(RecyclerView recyclerView, ArrayList<Section> section, ArrayList<Lesson> lesson){
        SectionsMenuAdapter adapter = new SectionsMenuAdapter(section, lesson);
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

    /**
     * this function will get all Sections from database passed by the viewModel class(DocumentViewModel.class)
     * and filtered by idYear;
     * @param idYear
     * @return it convert the liveData to arrayList and return it.
     */


    public MyListPair getAllSectionsAndLessons(int idYear, int idSection){
        MyListPair myListPair;
        documentViewModel = new DocumentViewModel(getApplication(), idYear, idSection);
        List<Section> sectionsList = documentViewModel.getmAllSections();
        List<Lesson> lessonsList = documentViewModel.getmAllLessons();
        ArrayList<Section> mSectionArrayList = new ArrayList<>();
        ArrayList<Lesson> mLessonArrayList = new ArrayList<>();
        mSectionArrayList.addAll(sectionsList);
        mLessonArrayList.addAll(lessonsList);
        myListPair = new MyListPair(mSectionArrayList, mLessonArrayList);
        return myListPair;
    }

    public class MyListPair{
        private ArrayList<Section> sectionList;
        private ArrayList<Lesson> lessonList;

        public MyListPair() {
        }

        public MyListPair(ArrayList<Section> sectionList, ArrayList<Lesson> lessonList) {
            this.sectionList = sectionList;
            this.lessonList = lessonList;
        }

        public ArrayList<Section> getSectionList() {
            return sectionList;
        }

        public void setSectionList(ArrayList<Section> sectionList) {
            this.sectionList = sectionList;
        }

        public ArrayList<Lesson> getLessonList() {
            return lessonList;
        }

        public void setLessonList(ArrayList<Lesson> lessonList) {
            this.lessonList = lessonList;
        }
    }
}