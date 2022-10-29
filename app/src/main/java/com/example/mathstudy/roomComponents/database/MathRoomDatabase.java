package com.example.mathstudy.roomComponents.database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mathstudy.roomComponents.dao.DocDao;
import com.example.mathstudy.roomComponents.entities.Categorie;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Season;
import com.example.mathstudy.roomComponents.entities.Year;

import java.io.File;

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
                            .createFromAsset("database/myDB.db").allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
                       Log.v("mathRoomDatabase: ", " slimane: "+INSTANCE.DocDao().getDocuments(1,1,1).size());
                       Log.v("mathRoomDatabase: ", " slimane2: "+INSTANCE.DocDao().getDocuments(1,1,1).get(1).getTitle());
                // Fixme: From this point of function by using log.v we ensure that the database is connected and return data
                }
            }
        }
        return INSTANCE;
    }

    // below line is to create a callback for our room database.
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // this method is called when database is created
            // and below line is to populate our data.
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    // we are creating an async task class to perform task in background.
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(MathRoomDatabase instance) {
            DocDao dao = instance.DocDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
