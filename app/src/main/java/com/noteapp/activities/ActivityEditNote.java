package com.noteapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.noteapp.R;
import com.noteapp.databases.CustomDbHelper;
import com.noteapp.models.Note;
import com.noteapp.utilites.Utils;

/**
 * Created by shopclues on 31/7/16.
 */

public class ActivityEditNote extends AppCompatActivity implements View.OnClickListener{



    private EditText etTitle;
    private EditText etDescription;
    private TextView tvModifiedTime, tvModifiedDate, tvSave;
    private String modifiedDateTime,modifiedTime;
    private  String createdDateTime;
    Note editNoteItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_main_card);

        Intent intent = getIntent();
        editNoteItem = intent.getParcelableExtra("editNoteItem");
        //createdDateTime = intent.getStringExtra("noteCreatedDateTime");

        etTitle = (EditText) findViewById(R.id.etNoteTitle);
        etDescription = (EditText) findViewById(R.id.etDescriptionNote);

        tvModifiedDate = (TextView) findViewById(R.id.tvNoteDate);
        tvModifiedTime = (TextView) findViewById(R.id.tvNoteTime);
        tvSave = (TextView) findViewById(R.id.tv_save_note);

        modifiedDateTime = Utils.getDate(System.currentTimeMillis());
        etTitle.setText(editNoteItem.title);
        etTitle.setSelection(editNoteItem.title.length());
        etDescription.setText(editNoteItem.description);

        tvModifiedDate.setText(modifiedDateTime);

        createdDateTime = editNoteItem.createdDateTime;
        tvSave.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_save_note){

            String currentDateTime = Utils.getDate(System.currentTimeMillis());
            //String currentTime = Utils.getCurrentTime(System.currentTimeMillis());
            String[] string = new String[]{etTitle.getText().toString(),etDescription.getText().toString(),currentDateTime,String.valueOf(1),createdDateTime};
            CustomDbHelper.getInstance(this).updateNoteTable(string);
            Toast.makeText(this, "Successfully Edited", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ActivityEditNote.this,ActivityNoteMain.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
