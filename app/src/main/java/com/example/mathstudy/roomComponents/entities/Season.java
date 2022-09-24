package com.example.mathstudy.roomComponents.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "seasons")
public class Season {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idSeason")
    private int idSeason;
    @ColumnInfo(name = "season")
    private String season;

    public Season() {
    }

    public Season(int idSeason, String season) {
        this.idSeason = idSeason;
        this.season = season;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
