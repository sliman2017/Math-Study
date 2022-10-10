package com.example.mathstudy.documentsRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mathstudy.roomComponents.dao.DocDao;
import com.example.mathstudy.roomComponents.database.RoomDatabase;
import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

public class DocumentsRepository {
    private DocDao mDocDao;
    private LiveData<List<Document>> mAllDocuments;
    public DocumentsRepository(Application application) {
        RoomDatabase database = RoomDatabase.getDatabase(application);
        mDocDao = (DocDao) database.DocDao();
        mAllDocuments = null;
    }
    public LiveData<List<Document>> getmAllDocuments(int idCat, int idYear, int idSeason){
        return mDocDao.getDocuments(idCat, idYear, idSeason);
    }
}
