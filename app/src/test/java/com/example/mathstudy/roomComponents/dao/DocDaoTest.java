package com.example.mathstudy.roomComponents.dao;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.mathstudy.roomComponents.database.MathRoomDatabase;
import com.example.mathstudy.roomComponents.entities.Document;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
public class DocDaoTest extends TestCase {

    private DocDao documentDao;
    private MathRoomDatabase mathRoomDatabase;
    @Before
    public void connectDB(){
    Context context = ApplicationProvider.getApplicationContext();
        mathRoomDatabase = Room.databaseBuilder(context, MathRoomDatabase.class, "myDB.db")
                .createFromAsset("database/myDB.db").allowMainThreadQueries()
                .build();
        documentDao = mathRoomDatabase.DocDao();
    }

    @After
    public void closeDb() throws IOException {
        mathRoomDatabase.close();
    }

    @Test
    public void readAllDocumentsInList()throws Exception{

        List<Document> myDocumentsLiveData = documentDao.getDocuments(1,1,1);
        assertEquals(myDocumentsLiveData.size(), 1);
    }
}