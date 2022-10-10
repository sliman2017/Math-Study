package com.example.mathstudy.roomComponents.database;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;

import com.example.mathstudy.roomComponents.dao.DocDao;
import com.example.mathstudy.roomComponents.entities.Categorie;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Season;
import com.example.mathstudy.roomComponents.entities.Year;

@Database(entities = {Year.class, Season.class, Document.class, Categorie.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    private static RoomDatabase INSTANCE;

    public abstract DocDao DocDao();

    public static RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomDatabase.class, "document_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
