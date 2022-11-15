package com.example.mathstudy.documentsRepository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.mathstudy.roomComponents.dao.DocDao;
import com.example.mathstudy.roomComponents.database.MathRoomDatabase;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Lesson;
import com.example.mathstudy.roomComponents.entities.Section;

import java.util.List;

public class DocumentsRepository {
    private DocDao mDocDao;
    private List<Document> mAllDocuments;
    private List<Section> mAllSections;
    private List<Lesson> mAllLessons;

    public DocumentsRepository(Application application) {
        MathRoomDatabase database = MathRoomDatabase.getDatabase(application);
        mDocDao = database.DocDao();
    }

    public DocumentsRepository(Application application, int idCat, int idYear, int idSection) {
        MathRoomDatabase database = MathRoomDatabase.getDatabase(application);
        mDocDao = database.DocDao();
        mAllDocuments = mDocDao.getDocuments(idCat, idYear, idSection);
        Log.v("my documents", "the size of mAllDocuments is: "+mAllDocuments.size());
        Log.v("my params", " the params is: "+idCat+", "+idYear+", "+idSection);
    }

    /**
     * this constructor use only two params as input (application and idYear)
     * it specific for returning Sections.
     * @param application
     * @param idYear
     */
    public DocumentsRepository(Application application, int idYear, int idSection){
        MathRoomDatabase database = MathRoomDatabase.getDatabase(application);
        mDocDao = database.DocDao();
        mAllSections = mDocDao.getSections(idYear);
        mAllLessons = mDocDao.getLessons(idSection);
        Log.v("my documents", "the size of mAllSections is: "+mAllSections.size());
        Log.v("my documents", "the size of mAllLessons is: "+mAllLessons.size());
        Log.v("my params", " the param is: "+idYear+", "+idSection);
    }

    public List<Document> getmAllDocuments(){
        return mAllDocuments;
    }

    public List<Section> getmAllSections(){
        return mAllSections;
    }

    public List<Lesson> getmAllLessons(){
        return mAllLessons;
    }

    public List<Lesson> getmeLessons(int idSection){
        mAllLessons = mDocDao.getLessons(idSection);
        return mAllLessons;
    }
    public List<Section> getmeSections(int idYear){
        mAllSections = mDocDao.getSections(idYear);
        return mAllSections;
    }
}
