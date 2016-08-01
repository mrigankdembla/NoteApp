package com.noteapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.noteapp.R;
import com.noteapp.databases.CustomDbHelper;
import com.noteapp.models.Note;

/**
 * Created by shopclues on 31/7/16.
 */

public class ActivityDisplayNote extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvModifiedDate, tvModifiedTime;
    private TextView tvEdit;
    private TextView tvDelete;
    private String createdDateTime,modifiedDateTime;
    private Note displayNoteItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_show_card);
        
        Intent intent = getIntent();
        displayNoteItem = intent.getParcelableExtra("noteObj");
        createdDateTime = displayNoteItem.createdDateTime;

        tvTitle = (TextView) findViewById(R.id.etNoteTitle);
        tvDescription = (TextView) findViewById(R.id.etDescriptionNote);
        tvModifiedDate = (TextView) findViewById(R.id.tvNoteDate);
        tvModifiedTime = (TextView) findViewById(R.id.tvNoteTime);

        tvEdit = (TextView) findViewById(R.id.tv_edit_note);
        tvDelete = (TextView) findViewById(R.id.tv_delete_note);

        tvTitle.setText(displayNoteItem.title);
        tvDescription.setText(displayNoteItem.description);
        tvModifiedDate.setText(displayNoteItem.modifiedDateTime);
     //   tvModifiedTime.setText(displayNoteItem.modifiedTime);

        tvEdit.setOnClickListener(this);
        tvDelete.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_edit_note){
            Intent intent = new Intent(ActivityDisplayNote.this,ActivityEditNote.class);
            //intent.putExtra("noteCreatedDateTime",createdDateTime);
            intent.putExtra("editNoteItem",displayNoteItem);
            startActivity(intent);
          //  overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
        else if(v.getId() == R.id.tv_delete_note){
            CustomDbHelper.getInstance(this).deleteNoteRow(createdDateTime);
            Toast.makeText(this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
