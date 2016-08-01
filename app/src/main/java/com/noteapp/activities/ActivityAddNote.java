package com.noteapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.noteapp.R;
import com.noteapp.databases.CustomDbHelper;
import com.noteapp.utilites.Utils;

/**
 * Created by shopclues on 30/7/16.
 */

public class ActivityAddNote extends AppCompatActivity implements View.OnClickListener{

    private EditText etTitle;
    private EditText etDescription;
    private TextView tvTime, tvDate, tvSave;
    private String createdDateTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_main_card);

        etTitle = (EditText) findViewById(R.id.etNoteTitle);
        etDescription = (EditText) findViewById(R.id.etDescriptionNote);

        tvDate = (TextView) findViewById(R.id.tvNoteDate);
        tvTime = (TextView) findViewById(R.id.tvNoteTime);

        //if(CustomDbHelper.getInstance(this).getCreatedDateTime())

       createdDateTime = Utils.getDate(System.currentTimeMillis());

        tvDate.setText(createdDateTime);



        tvSave = (TextView) findViewById(R.id.tv_save_note);


        tvSave.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_save_note){

            String currentDateTime = Utils.getDate(System.currentTimeMillis());
            //String currentTime = Utils.getCurrentTime(System.currentTimeMillis());
            String[] string = new String[]{etTitle.getText().toString(),etDescription.getText().toString(),createdDateTime,currentDateTime,String.valueOf(1)};
            CustomDbHelper.getInstance(this).insertIntoTable(this.getResources().getString(R.string.table_name_note),string);
            Toast.makeText(this, "Successfully Created", Toast.LENGTH_SHORT).show();
            finish();

        }
    }
}
