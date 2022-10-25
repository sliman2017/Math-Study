package com.example.mathstudy.roomComponents.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.security.KeyStore;

@Entity(tableName = "Years")
public class Year {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idYear")
    // FIXME: this @NonNull annotation doesn't work i have to fixe it
    private int idYear;
    @ColumnInfo(name = "year")
    private String year;

    @Ignore
    public Year() {
    }

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
