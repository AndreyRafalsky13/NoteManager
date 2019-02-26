package com.rafalsky.firebaselesson1.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.rafalsky.firebaselesson1.model.DatabaseHelper.NoteCollection;
import com.rafalsky.firebaselesson1.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteViewModel extends ViewModel {
    private FirebaseFirestore database;
    private List<Note> notes;

    public NoteViewModel(){
        notes = new ArrayList<>();
        database = FirebaseFirestore.getInstance();
    }

    public void saveNote(Context context, Note note){
        database.collection(NoteCollection.COLLECTION_NAME).document(note.getCreationDate())
                .set(note)
                .addOnSuccessListener(voidObject -> {
                    Toast.makeText(context, "Note was saved", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(exception -> {
                    Toast.makeText(context, "Error while saving a note", Toast.LENGTH_SHORT).show();
                    exception.printStackTrace();
                });
    }

    public List<Note> loadNotes(){
        database.collection(NoteCollection.COLLECTION_NAME)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    notes.addAll(queryDocumentSnapshots.toObjects(Note.class));
                    Log.d("loadingNote", String.valueOf(notes.size()));
                })
                .addOnFailureListener(e -> {
                    Log.d("loadingNote", e.toString());
                });
        Log.d("loadingNote", String.valueOf(notes.size()));
        return notes;
    }


}
