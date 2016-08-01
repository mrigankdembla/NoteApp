package com.noteapp.activities;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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
        //fabAddNote.getContentBackground().setColorFilter(getResources().getColor(R.color.mainLayoutBackground), PorterDuff.Mode.MULTIPLY);
        fabAddNote.setOnClickListener(this);


        adapterMainNotes = new AdapterMainNotes(CustomDbHelper.getInstance(this).getNoteList());
        //rvMain.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapterMainNotes);

        adapterMainNotes.setOnNoteItemClickListener(new AdapterMainNotes.CustomChildClickListener() {
            @Override
            public void onClickNoteItem(Note noteItem, int position) {
                Intent intent = new Intent(ActivityNoteMain.this,ActivityDisplayNote.class);
                intent.putExtra("noteObj",noteItem);
                //intent.putExtra("noteCreatedDateTime",noteItem.createdDate + "," + noteItem.createdTime);
                startActivity(intent);

            }
        });


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
           // overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
    }
}
