package com.example.mathstudy.roomComponents.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Categorie {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idCategorie")
    private int idCategorie;
    @ColumnInfo(name = "categorie")
    private String categorie;

    public Categorie() {
    }

    public Categorie(int idCategorie, String categorie) {
        this.idCategorie = idCategorie;
        this.categorie = categorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
