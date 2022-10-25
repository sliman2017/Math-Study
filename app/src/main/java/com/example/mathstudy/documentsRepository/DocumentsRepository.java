package com.example.mathstudy.documentsRepository;

import android.app.Application;

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
        mDocDao = (DocDao) database.DocDao();
        mAllDocuments = mDocDao.getDocuments(idCat, idYear, idSeason);
    }
    public List<Document> getmAllDocuments(){
        return mAllDocuments;
    }
}
