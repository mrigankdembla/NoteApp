package com.noteapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.noteapp.R;
import com.noteapp.adapters.AdapterMainNotes;
import com.noteapp.databases.CustomDbHelper;
import com.noteapp.models.Note;

import java.util.ArrayList;

public class ActivityNoteMain extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvMain;
    private AdapterMainNotes adapterMainNotes;
    private FloatingActionButton fabAddNote;
    private ArrayList<Note> noteArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_main);
        rvMain =  (RecyclerView) findViewById(R.id.rvMain);
        fabAddNote = (FloatingActionButton) findViewById(R.id.fabAddNote);

        fabAddNote.setOnClickListener(this);


        adapterMainNotes = new AdapterMainNotes(CustomDbHelper.getInstance(this).getNoteList());
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapterMainNotes);



    }

    @Override
    protected void onResume() {
        super.onResume();
        adapterMainNotes.setList(CustomDbHelper.getInstance(this).getNoteList());
        adapterMainNotes.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fabAddNote ){
            Intent intent = new Intent(ActivityNoteMain.this,ActivityAddNote.class);
            startActivity(intent);
        }
    }
}
