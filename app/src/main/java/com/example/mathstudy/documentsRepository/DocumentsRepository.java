package com.example.mathstudy.documentsRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.mathstudy.roomComponents.dao.Dao;
import com.example.mathstudy.roomComponents.database.RoomDatabase;
import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

public class DocumentsRepository {
    private Dao mDao;
    private LiveData<List<Document>> mAllDocuments;
    public DocumentsRepository(Application application) {
        RoomDatabase database = RoomDatabase.getDatabase(application);
        mDao = (Dao) database.Dao();
    }
    public LiveData<List<Document>> getmAllDocuments(int idCat, int idYear, int idSeason){
        return mDao.getDocuments(idCat, idYear, idSeason);
    }
}
