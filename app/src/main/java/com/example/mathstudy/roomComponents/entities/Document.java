package com.example.mathstudy.roomComponents.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "documents",
        foreignKeys = {
                @ForeignKey(entity = Categorie.class,
                        parentColumns = "idCategorie",
                        childColumns = "idCategorie"),
                @ForeignKey(entity = Year.class,
                        parentColumns = "idYear",
                        childColumns = "idYear"),
                @ForeignKey(entity = Season.class,
                        parentColumns = "idSeason",
                        childColumns = "idSeason")
        })
public class Document {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idDocument")
    private int idDocument;
    @ColumnInfo(name="idCategorie")
    private int idCategorie;
    @ColumnInfo(name = "idYear")
    private int idyear;
    @ColumnInfo(name = "idSeason")
    private int idSeason;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "pic",
            typeAffinity = ColumnInfo.BLOB)
    private byte[] pic;
    @ColumnInfo(name = "link")
    private String link;

    public Document() {
    }

    public Document(int idDocument, int idCategorie, int idyear, int idSeason, String title, byte[] pic, String link) {
        this.idDocument = idDocument;
        this.idCategorie = idCategorie;
        this.idyear = idyear;
        this.idSeason = idSeason;
        this.title = title;
        this.pic = pic;
        this.link = link;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdyear() {
        return idyear;
    }

    public void setIdyear(int idyear) {
        this.idyear = idyear;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
