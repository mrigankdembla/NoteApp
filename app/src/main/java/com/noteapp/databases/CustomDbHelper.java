package com.noteapp.databases;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.noteapp.R;

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



}
