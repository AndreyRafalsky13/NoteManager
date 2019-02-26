package com.rafalsky.firebaselesson1.view.fragments;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.rafalsky.firebaselesson1.R;
import com.rafalsky.firebaselesson1.adapters.NoteAdapter;
import com.rafalsky.firebaselesson1.model.DatabaseHelper;
import com.rafalsky.firebaselesson1.model.Note;
import com.rafalsky.firebaselesson1.viewmodel.NoteViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private RecyclerView noteRecycleView;
    private NoteViewModel model;

    public NoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        updateUI();
    }


    private void updateUI() {
        List<Note> notes = model.loadNotes();
        NoteAdapter adapter = new NoteAdapter(getActivity(), notes);
        noteRecycleView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void init(View view) {
        noteRecycleView = view.findViewById(R.id.note_recycle_view);
        noteRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        model = ViewModelProviders.of(getActivity()).get(NoteViewModel.class);

    }
}
