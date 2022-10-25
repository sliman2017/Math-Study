package com.example.mathstudy.roomComponents.dao;

import android.content.Context;

import androidx.lifecycle.LiveData;
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

import java.io.IOException;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
public class DocDaoTest extends TestCase {

    private DocDao documentDao;
    private MathRoomDatabase mathRoomDatabase;
    @Before
    public void connectDB(){
    Context context = ApplicationProvider.getApplicationContext();
        mathRoomDatabase = Room.databaseBuilder(context, MathRoomDatabase.class, "document_database")
                .createFromAsset("databases/document_database.db")
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

    // TODO: test the connection between the sqlite databases and the java code

}