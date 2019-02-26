package com.rafalsky.firebaselesson1.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Note {
    private String noteText;
    private String creationDate;

    public Note(){}

    public Note(String noteText){
        this.noteText = noteText;
        creationDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.UK).format(new Date());
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
