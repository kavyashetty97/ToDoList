package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper {


    private static final String DB_TABLE = "task";
    private static final String DB_COLUMN = "taskName";

    public dbhelper(Context context) {
        super(context, "kavya", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS hello(ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEMS TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS hello");
        onCreate(db);

    }

    public boolean adddata(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(DB_COLUMN,task);

        long result = db.insert("hello",null,c);

        if(result == -1){
            return false;
        }else {
            return true;
        }


    }

    public Cursor getlistcontents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM hello",null);
        return data;


    }


}
