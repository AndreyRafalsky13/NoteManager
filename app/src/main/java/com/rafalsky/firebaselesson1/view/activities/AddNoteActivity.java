package com.rafalsky.firebaselesson1.view.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rafalsky.firebaselesson1.R;
import com.rafalsky.firebaselesson1.model.Note;
import com.rafalsky.firebaselesson1.viewmodel.NoteViewModel;

public class AddNoteActivity extends AppCompatActivity {

    private NoteViewModel model;

    private EditText noteTextEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        init();
    }

    private void init() {
        model = ViewModelProviders.of(this).get(NoteViewModel.class);

        noteTextEdit = findViewById(R.id.note_edit);
    }

    public static Intent getInstance(Context context){
        Intent intent = new Intent(context, AddNoteActivity.class);
        return intent;
    }

    public void saveOnClick(View view) {
        String noteText = noteTextEdit.getText().toString();

        if (!noteText.isEmpty()){
            model.saveNote(this, new Note(noteText));
        }else {
            Toast.makeText(this, "Enter some text", Toast.LENGTH_SHORT).show();
        }
    }
}
