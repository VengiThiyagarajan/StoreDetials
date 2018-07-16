package com.example.vengithiyagarajan.storedetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vengi Thiyagarajan on 23-11-2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db2";
    public static final String TABLE_NAME = "student_table2";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "AADHAR_NO";
    public static final String COL_4 = "RATIONCARD_NO";
    public static final String COL_pan = "PANCARD";
    public static final String COL_bank = "BANK";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AADHAR_NO INTEGER,RATIONCARD_NO INTEGER,PANCARD INTEGER,BANK INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  EXITS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String aadhar_no, String rationcard_no,String pancard,String bankno)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,aadhar_no);
        contentValues.put(COL_4, rationcard_no);
        contentValues.put(COL_pan,pancard);
        contentValues.put(COL_bank,bankno);


        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getALLData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updatedata(String id,String name,String aadhar_no,String rationcard_no,String pancard,String bankno)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,aadhar_no);
        contentValues.put(COL_4, rationcard_no);
        contentValues.put(COL_pan, pancard);
        contentValues.put(COL_bank,bankno);

        db.update(TABLE_NAME,contentValues, "ID = ?", new String[] { id} );
        return true;
    }
    public Integer deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String []{id});
    }


}