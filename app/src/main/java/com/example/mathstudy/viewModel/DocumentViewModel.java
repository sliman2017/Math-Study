package com.example.mathstudy.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mathstudy.documentsRepository.DocumentsRepository;
import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

public class DocumentViewModel extends AndroidViewModel {

    private DocumentsRepository mRepository;
    private final List<Document> mDocuments;

    public DocumentViewModel(@NonNull Application application, int idCat, int idYear, int idSeason) {
        super(application);
        mRepository = new DocumentsRepository(application, idCat, idYear, idSeason);
        mDocuments = mRepository.getmAllDocuments();
    }
    public List<Document> getmAllDocuments(){
        return mDocuments;
    }
}
