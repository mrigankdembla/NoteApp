package com.noteapp.databases;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.noteapp.R;
import com.noteapp.models.Note;
import com.noteapp.utilites.Utils;

import java.util.ArrayList;

/**
 * Created by shopclues on 30/7/16.
 */

public class CustomDbHelper extends SQLiteOpenHelper {

    private static CustomDbHelper customDbHelper;
    private Resources resourceString;

    private CustomDbHelper(Context context){
        this(context,context.getResources().getString(R.string.db_name),null,Integer.parseInt(context.getResources().getString(R.string.db_version)));
        this.resourceString = context.getResources();
    }

    private CustomDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {

        db.execSQL(resourceString.getString(R.string.create_table_note));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static CustomDbHelper getInstance(Context context){
        if(customDbHelper == null){
            customDbHelper = new CustomDbHelper(context);
        }
        return customDbHelper;
    }


    public void insertIntoTable(String tableName,String[] values){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(resourceString.getString(R.string.insert_table_note),values);

    }


    public ArrayList<Note> getNoteList(){
        ArrayList<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM NOTE",null);

        if(Utils.objectValidator(cursor)&&cursor.getCount() > 0){
            cursor.moveToFirst();

            while(cursor.moveToNext()){
                Note note = new Note();
                note.title = cursor.getString(cursor.getColumnIndexOrThrow("TITLE"));
                note.description = cursor.getString(cursor.getColumnIndexOrThrow("DESCRIPTION"));
                note.noteType = cursor.getInt(cursor.getColumnIndexOrThrow("TYPE"));
                String createdDateTime = cursor.getString(cursor.getColumnIndexOrThrow("CREATED_DATE_TIME"));
                String modifiedDateTime = cursor.getString(cursor.getColumnIndexOrThrow("MODIFIED_DATE_TIME"));

                String[] parseCreatedDateTime = createdDateTime.split(",");
                if(Utils.objectValidator(parseCreatedDateTime)) {
                    note.createdDate = parseCreatedDateTime[0];
                    note.createdTime = parseCreatedDateTime[1];
                }

                String[] parseModifiedDateTime = modifiedDateTime.split(",");
                if(Utils.objectValidator(parseModifiedDateTime)){
                    note.modifiedDate = parseModifiedDateTime[0];
                    note.modifiedTime = parseModifiedDateTime[1];
                }
                noteList.add(note);
            }


        }
        return noteList;
    }


}
