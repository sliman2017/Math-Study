package com.example.mathstudy.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mathstudy.documentsRepository.DocumentsRepository;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Lesson;
import com.example.mathstudy.roomComponents.entities.Section;

import java.util.List;

public class DocumentViewModel extends AndroidViewModel {

    private DocumentsRepository mRepository;
    private List<Document> mDocuments;
    private List<Section> mSections;
    private List<Lesson> mLessons;

    public DocumentViewModel(@NonNull Application application, int idCat, int idYear, int idSection) {
        super(application);
        mRepository = new DocumentsRepository(application, idCat, idYear, idSection);
        mDocuments = mRepository.getmAllDocuments();
    }

    /**
     * this constructor is for the returning sections by the idYear param
     * @param application
     * @param idYear
     */
    public DocumentViewModel(@NonNull Application application, int idYear, int idSection){
        super(application);
        mRepository = new DocumentsRepository(application, idYear, idSection);
        mSections = mRepository.getmAllSections();
        mLessons = mRepository.getmAllLessons();
    }

    public List<Document> getmAllDocuments(){
        return mDocuments;
    }

    public List<Section> getmAllSections(){
        return mSections;
    }

    public List<Lesson> getmAllLessons(){
        return mLessons;
    }
}
