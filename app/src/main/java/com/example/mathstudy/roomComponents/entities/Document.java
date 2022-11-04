package com.example.mathstudy.roomComponents.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Documents",
        foreignKeys = {
                @ForeignKey(entity = Categorie.class,
                        parentColumns = "idCategorie",
                        childColumns = "idCategorie"),
                @ForeignKey(entity = Year.class,
                        parentColumns = "idYear",
                        childColumns = "idYear"),
                @ForeignKey(entity = Lesson.class,
                        parentColumns = "idLesson",
                        childColumns = "idLesson")
        })
public class Document {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="idDocument")
    private int idDocument;
    @ColumnInfo(name="idCategorie", index = true)
    private int idCategorie;
    @ColumnInfo(name = "idYear", index = true)
    private int idyear;
    @ColumnInfo(name = "idLesson", index = true)
    private int idLesson;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "subTitle")
    private String subTitle;
    @ColumnInfo(name = "pic",
            typeAffinity = ColumnInfo.BLOB)
    private byte[] pic;
    @ColumnInfo(name = "link")
    private String link;

    @Ignore
    public Document() {
    }

    public Document(int idDocument, int idCategorie, int idyear, int idLesson, String title, String subTitle, byte[] pic, String link) {
        this.idDocument = idDocument;
        this.idCategorie = idCategorie;
        this.idyear = idyear;
        this.idLesson = idLesson;
        this.title = title;
        this.subTitle = subTitle;
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

    public int getidLesson() {
        return idLesson;
    }

    public void setidLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
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
