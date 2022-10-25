package com.example.mathstudy.roomComponents.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.mathstudy.roomComponents.entities.Document;

import java.util.List;

@Dao
public interface DocDao {
    @Query("SELECT * FROM Documents WHERE idCategorie = :idCategorie " +
            "and idYear = :idYear " +
            "and idSeason = :idSeason")
    List<Document> getDocuments(int idCategorie, int idYear, int idSeason);
    // TODO: fetch data from sqlite databases room to recyclerView in Documents Activity
}
