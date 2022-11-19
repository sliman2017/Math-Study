package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mathstudy.R;
import com.example.mathstudy.adapters.DocumentsMenuAdapter;
import com.example.mathstudy.interfaces.ItemClickListener;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.viewModel.DocumentViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * this class it's an activity that show the all documents for specific categories
 * for first and second and third trimester
 */
public class Documents extends AppCompatActivity {

    private ArrayList<Document> t1Documents = new ArrayList<>();
    private CardView t1Card;
    private RecyclerView t1Recycler;
    private ItemClickListener itemClickListener;
    private int mSchoolLevelID;
    private int mCategorieID;
    private int mLessonID;
    private DocumentViewModel documentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initListeners();
        dataReceiver();
        // TODO: retrieve images from sqlite room database and put in the next line
        t1Documents.addAll(getAllDocuments(Sections.mCategorieID, 1, mLessonID));
        Log.v("myTestMessage: ", " idCat: "+ Sections.mCategorieID + ", mSchoolID: "+mSchoolLevelID+ ", mLessonID: "+ mLessonID);
        setUpDocsModels();
        fillRecyclerDocuments(t1Recycler, t1Documents);
    }


    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    private void initViews() {
        setContentView(R.layout.activity_documents);
        t1Recycler = (RecyclerView) findViewById(R.id.t1_recycler);
    }

    /**
     * this function will contain all the listeners in this activity
     */
    private void initListeners(){

    }

    /**
     * this function will fill the documents data from database resource and put them in
     * the arrayList<Document> variable that declared above.
     */
    private void setUpDocsModels() {
        t1Documents.add(new Document(1,1,1,1,"The equations", "More than 30 exercices", null, "http://www.mathStudy.com"));
        t1Documents.add(new Document(2,2,2,2,"The calculus", "50 exercices with solutions", null, "http://www.mathStudy.com"));
        t1Documents.add(new Document(3,3,3,3,"Algebric", "Tasks without solutions", null, "http://www.mathStudy.com"));
        t1Documents.add(new Document(4,4,4,4,"Quadratique equations", "No exercices exist", null, "http://www.mathStudy.com"));
        t1Documents.add(new Document(5,5,5,5,"Geometricue", "More than 4 exercices", null, "http://www.mathStudy.com"));
    }

    /**
     * this function will attach the adapter to the recyclerView
     * @param recyclerView this parameter will be the one of these three
     *                     recycler t1Recycler, t2Recycler or t3Recycler.
     *                     with t means trimester.
     * @param documents will be the list of documents for the trimester_1, trimester_2
     *                  or trimester_3 in the chosen Categorie.
     */
    public void fillRecyclerDocuments(RecyclerView recyclerView, ArrayList<Document> documents){
        DocumentsMenuAdapter adapter = new DocumentsMenuAdapter(documents);
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
            mLessonID = extras.getInt("lesson_id");
        }
        SharedPreferences schoolLevel = getSharedPreferences("schoolLevel", MODE_PRIVATE);
        mSchoolLevelID = schoolLevel.getInt("mySchoolLevel", 0);

    }

    /**
     * this function will get all Document from database passed by the viewModel class(DocumentViewModel.class)
     * and filtered by Categorie, School_Level and Section;
     * @param idCategorie
     * @param myLevel
     * @param idSeason
     * @return it convert the liveData to arrayList and return it.
     */
    public ArrayList<Document> getAllDocuments(int idCategorie, int myLevel, int idSeason){
        documentViewModel = new DocumentViewModel(getApplication(), idCategorie, myLevel, idSeason);
        List<Document> mData = documentViewModel.getmAllDocuments();
        ArrayList<Document> mDataArrayList = new ArrayList<>();
        mDataArrayList.addAll(mData);
        return mDataArrayList;
    }

}