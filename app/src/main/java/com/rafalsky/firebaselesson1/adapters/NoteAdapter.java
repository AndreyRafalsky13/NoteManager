package com.rafalsky.firebaselesson1.adapters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rafalsky.firebaselesson1.R;
import com.rafalsky.firebaselesson1.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes;
    private Context context;

    public NoteAdapter(Context context, List<Note> notes){
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        return new NoteHolder(LayoutInflater.from(context), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int position) {
        Note note = notes.get(position);
        noteHolder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {

        private TextView noteText;

        public NoteHolder(@NonNull LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.note_item, viewGroup, false));

            init();
        }

        private void init() {
            noteText = itemView.findViewById(R.id.note_text);
        }

        public void bind(Note note){
            noteText.setText(note.getNoteText());
        }
    }
}
