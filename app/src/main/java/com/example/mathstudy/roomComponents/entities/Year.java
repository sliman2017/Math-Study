package com.example.mathstudy.roomComponents.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.security.KeyStore;

@Entity(tableName = "Years")
//@Entity(tableName = "Year", indices={@Index(value="idYear", unique=true)})
public class Year {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idYear")
    private int idYear;
    @ColumnInfo(name = "year")
    private String year;

    public Year(@NonNull int idYear, String year) {
        this.idYear = idYear;
        this.year = year;
    }

    public int getIdYear() {
        return idYear;
    }

    public void setIdYear(int idYear) {
        this.idYear = idYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
