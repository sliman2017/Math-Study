package com.example.mathstudy.roomComponents.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mathstudy.roomComponents.dao.DocDao;
import com.example.mathstudy.roomComponents.entities.Categorie;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Season;
import com.example.mathstudy.roomComponents.entities.Year;

@Database(entities = {Year.class, Season.class, Document.class, Categorie.class}, version = 1, exportSchema = false)
public abstract class MathRoomDatabase extends RoomDatabase {

    private static volatile MathRoomDatabase INSTANCE;

    public abstract DocDao DocDao();

    public static MathRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MathRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MathRoomDatabase.class, "document_database")
                            .createFromAsset("databases/document_database.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
