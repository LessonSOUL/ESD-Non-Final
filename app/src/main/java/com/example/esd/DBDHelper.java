package com.example.esd;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBDHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DocumentsDB";
    public static final String TABLE_DOCS = "Documents";

    public static final String KEY_ID = "_id";
    public static final String NAME = "name";
    public static final String PATH = "path";
    public static final String Subscribes = "subs";

    public DBDHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_DOCS + " (" + KEY_ID + " integer primary key autoincrement,"
        + NAME + " text," + PATH + " text," + Subscribes + "text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists " +TABLE_DOCS);

        onCreate(db);
    }
}
