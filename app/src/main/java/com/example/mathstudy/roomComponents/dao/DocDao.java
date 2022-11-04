package com.example.mathstudy.roomComponents.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Lesson;
import com.example.mathstudy.roomComponents.entities.Section;

import java.util.List;

@Dao
public interface DocDao {
    @Query("SELECT * FROM Documents WHERE idCategorie == :idCategorie " +
            "and idYear == :idYear " +
            "and idLesson == :idLesson")
    List<Document> getDocuments(int idCategorie, int idYear, int idLesson);

    @Query("SELECT * FROM Sections WHERE idYear == :idYear")
    List<Section> getSections(int idYear);

    @Query("SELECT * FROM Lessons WHERE idSection == :idSection")
    List<Lesson> getLessons(int idSection);
}
