package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
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
    private CardView t1Card, t2Card, t3Card;
    private RecyclerView t1Recycler, t2Recycler, t3Recycler;
    private LinearLayoutCompat t1LinearLayout, t2LinearLayout, t3LinearLayout;
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
        // TODO: retrieve images from sqlite room databases and put in the next line
        t1Documents.addAll(getAllDocuments(mCategorie, mSchoolLevel, 1));
        setUpDocsModels();
        fillRecyclerDocuments(t1Recycler, t1Documents);
        fillRecyclerDocuments(t2Recycler, t1Documents);
        fillRecyclerDocuments(t3Recycler, t1Documents);
    }


    /**
     * this function will initialize all the xml views in java objects by findViewById function.
     */
    private void initViews() {
        setContentView(R.layout.activity_documents);
        t1Card = (CardView) findViewById(R.id.t1_card);
        t2Card = (CardView) findViewById(R.id.t2_card);
        t3Card = (CardView) findViewById(R.id.t3_card);
        t1Recycler = (RecyclerView) findViewById(R.id.t1_recycler);
        t2Recycler = (RecyclerView) findViewById(R.id.t2_recycler);
        t3Recycler = (RecyclerView) findViewById(R.id.t3_recycler);
        t1LinearLayout = (LinearLayoutCompat) findViewById(R.id.t1_linearLayout);
        t2LinearLayout = (LinearLayoutCompat) findViewById(R.id.t2_linearLayout);
        t3LinearLayout = (LinearLayoutCompat) findViewById(R.id.t3_linearLayout);
    }

    /**
     * this function will contain all the listeners in this activity
     */
    private void initListeners(){
        t1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mv = (t1Recycler.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(t1LinearLayout, new AutoTransition());
                t1Recycler.setVisibility(mv);
            }
        });
        t2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mv = (t2Recycler.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(t2LinearLayout, new AutoTransition());
                t2Recycler.setVisibility(mv);
            }
        });
        t3Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mv = (t3Recycler.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(t3LinearLayout, new AutoTransition());
                t3Recycler.setVisibility(mv);
            }
        });
    }

    /**
     * this function will fill the documents data from databases resource and put them in
     * the arrayList<Documents> variable that declared above.
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
     *                  or trimester_3 in the chosen Categories.
     */
    public void fillRecyclerDocuments(RecyclerView recyclerView, ArrayList<Document> documents){
        DocumentsMenuAdapter adapter = new DocumentsMenuAdapter(documents);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * this function will receive the data which is (Level and Year) from sharedPreferences
     * and the Intent coming from categories which is (Categories type)
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
     * this function will get all Documents from databases passed by the viewModel class(DocumentViewModel.class)
     * and filtered by Categories, School_Level and Season;
     * @param idCategorie
     * @param myLevel
     * @param idSeason
     * @return it convert the liveData to arrayList and return it.
     */
    public ArrayList<Document> getAllDocuments(int idCategorie, int myLevel, int idSeason){
        documentViewModel = new ViewModelProvider(this).get(DocumentViewModel.class);
        List<Document> mData = documentViewModel.getmAllDocuments();
        ArrayList<Document> mDataArrayList = new ArrayList<>();
        mDataArrayList.addAll(mData);
        return mDataArrayList;
    }

}