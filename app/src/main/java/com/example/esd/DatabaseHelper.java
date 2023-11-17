package com.example.esd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UsersDB";
    public static final String TABLE_USERS = "reg_users";

    public static final String KEY_ID = "_id";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String NLS = "full_name";
    public static final String VOZ = "voz";
    public static final String Special = "spec";
    public static final String Grp = "grp";
    public static final String MK = "mk";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_USERS + "(" + KEY_ID + " integer primary key autoincrement,"
        + PHONE + " text," + PASSWORD + " text," + NLS + " text," + VOZ + " text," + Special + " text,"
        + Grp + " text," + MK + " text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists " +TABLE_USERS);

        onCreate(db);
    }

}
