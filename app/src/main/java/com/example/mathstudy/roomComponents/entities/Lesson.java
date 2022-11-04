package com.example.mathstudy.roomComponents.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Lessons",
        foreignKeys = {
                @ForeignKey(entity = Section.class,
                        parentColumns = "idSection",
                        childColumns = "idSection")
        })
public class Lesson {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idLesson")
    private int idLesson;
    @ColumnInfo(name = "idSection", index = true)
    private int idSection;
    @ColumnInfo(name = "lessonTitle")
    private String lessonTitle;
    @ColumnInfo(name = "lessonSubTitle")
    private String lessonSubTitle;

    @Ignore
    public Lesson() {
    }

    public Lesson(int idLesson, int idSection, String lessonTitle, String lessonSubTitle) {
        this.idLesson = idLesson;
        this.idSection = idSection;
        this.lessonTitle = lessonTitle;
        this.lessonSubTitle = lessonSubTitle;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonSubTitle() {
        return lessonSubTitle;
    }

    public void setLessonSubTitle(String lessonSubTitle) {
        this.lessonSubTitle = lessonSubTitle;
    }
}
