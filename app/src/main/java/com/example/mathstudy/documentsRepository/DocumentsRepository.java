package com.example.mathstudy.documentsRepository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.mathstudy.roomComponents.dao.DocDao;
import com.example.mathstudy.roomComponents.database.MathRoomDatabase;
import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

public class DocumentsRepository {
    private DocDao mDocDao;
    private List<Document> mAllDocuments;
    public DocumentsRepository(Application application, int idCat, int idYear, int idSeason) {
        MathRoomDatabase database = MathRoomDatabase.getDatabase(application);
        mDocDao = database.DocDao();
        mAllDocuments = mDocDao.getDocuments(idCat, idYear, idSeason);
        Log.v("my documents", "the size is: "+mAllDocuments.size());
        Log.v("my params", " the params is: "+idCat+", "+idYear+", "+idSeason);
    }
    public List<Document> getmAllDocuments(){
        return mAllDocuments;
    }
}
