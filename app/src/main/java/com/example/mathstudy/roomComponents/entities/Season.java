package com.example.mathstudy.roomComponents.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Seasons")
public class Season {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idSeason")
    private int idSeason;
    @ColumnInfo(name = "season")
    private String season;

    @Ignore
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
