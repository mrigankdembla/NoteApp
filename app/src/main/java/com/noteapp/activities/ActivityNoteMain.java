package com.noteapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.noteapp.R;
import com.noteapp.adapters.AdapterMainNotes;

public class ActivityNoteMain extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvMain;
    private AdapterMainNotes adapterMainNotes;
    private FloatingActionButton fabAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_main);
        rvMain =  (RecyclerView) findViewById(R.id.rvMain);
        fabAddNote = (FloatingActionButton) findViewById(R.id.fabAddNote);

        fabAddNote.setOnClickListener(this);


        adapterMainNotes = new AdapterMainNotes();


    }

    @Override
    protected void onResume() {
        super.onResume();

        

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fabAddNote ){
            Intent intent = new Intent(ActivityNoteMain.this,ActivityAddNote.class);
            startActivity(intent);
        }
    }
}
