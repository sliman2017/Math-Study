package com.example.mathstudy.roomComponents.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Years")
public class Year {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idYear")
    private int idYear;
    @ColumnInfo(name = "year")
    private String year;

    public Year() {
    }

    public Year(int idYear, String year) {
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
