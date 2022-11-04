package com.example.mathstudy.roomComponents.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sections",
        foreignKeys = {
                @ForeignKey(entity = Year.class,
                        parentColumns = "idYear",
                        childColumns = "idYear")
        })
public class Section {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idSection")
    private int idSection;
    @ColumnInfo(name = "idYear")
    private int idYear;
    @ColumnInfo(name = "sectionTitle")
    private String sectionTitle;
    @ColumnInfo(name = "sectionSubTitle")
    private String sectionSubTitle;

    @Ignore
    public Section() {
    }

    public Section(int idSection, String sectionTitle) {
        this.idSection = idSection;
        this.sectionTitle = sectionTitle;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public int getIdYear() {
        return idYear;
    }

    public void setIdYear(int idYear) {
        this.idYear = idYear;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionSubTitle() {
        return sectionSubTitle;
    }

    public void setSectionSubTitle(String sectionSubTitle) {
        this.sectionSubTitle = sectionSubTitle;
    }
}
