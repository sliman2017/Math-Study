package com.example.mathstudy.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mathstudy.documentsRepository.DocumentsRepository;
import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

public class DocumentViewModel extends AndroidViewModel {

    private DocumentsRepository mRepository;
    private LiveData<List<Document>> mDocuments;

    public DocumentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new DocumentsRepository(application);
        mDocuments = null;
    }
    LiveData<List<Document>> getmDocuments(int idCat, int idYear, int idSeason){
        mDocuments = mRepository.getmAllDocuments(idCat, idYear, idSeason);
        return mDocuments;
    }
}
