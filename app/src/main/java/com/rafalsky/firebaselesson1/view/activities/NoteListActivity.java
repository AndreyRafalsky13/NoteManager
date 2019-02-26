package com.rafalsky.firebaselesson1.view.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.rafalsky.firebaselesson1.R;

public class NoteListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton addNoteFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);

        init();
        setListeners();
    }

    private void setListeners() {
        addNoteFab.setOnClickListener(view -> {
            Intent intent = AddNoteActivity.getInstance(this);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void init() {
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        addNoteFab = findViewById(R.id.floatingActionButton);
    }
}
