package com.example.mathstudy.roomComponents.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM documents WHERE idCategorie = :idCategorie " +
            "and idYear = :idYear " +
            "and idSeason = :idSeason")
    LiveData<List<Document>> getDocuments(int idCategorie, int idYear, int idSeason);
}
