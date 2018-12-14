package com.example.hassan.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String db = "attendence.db";
    private static final String student = "student";
    private static final String faculty = "faculty";

    public DatabaseHelper(Context context) {
        super(context, db, null, 3);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE  TABLE " + student + " (Id INTEGER primary key autoincrement,Name TEXT,Department TEXT,Rollno TEXT) ");
            db.execSQL("CREATE TABLE " + faculty + " (Id INTEGER primary key autoincrement,Name TEXT,Department TEXT,Salary INTEGER) ");
        db.execSQL("Create TABLE Attendence (Id INTEGER PRIMARY KEY AUTOINCREMENT,Rollno TEXT,Status TEXT) ");
        } catch (SQLException e) {
            Log.i("Error", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("Drop table if exists " + student + "");
            db.execSQL("Drop table if exists " + faculty + "");
            db.execSQL("Drop table if exists Attendence");
            onCreate(db);
        } catch (SQLException e) {
            Log.i("ErrorU", e.getMessage());
        }
    }

    public boolean insertStudent(String name, String Dep, String roll) {
        SQLiteDatabase dba = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("Name", name);
        v.put("Department", Dep);
        v.put("Rollno", roll);

        long r = dba.insert(student, null, v);

        if (r == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor ViewStudent() {
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "Select * from student";
        Cursor cursor = database.rawQuery(q, null);
        return cursor;
    }


    public boolean AddFaculty(String name,String dep,int salary) {

        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues v = new ContentValues();
            v.put("Name", name);
            v.put("Department", dep);
            v.put("Salary", salary);

            long r = database.insert(faculty, null, v);

            if (r == -1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            Log.i("ErrorF", e.getMessage());
            return false;
        }

    }

    public Cursor ViewFaculty() {
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "Select * from "+faculty+"";
        Cursor cursor = database.rawQuery(q, null);
        return cursor;
    }


    public boolean attendence(String roll,String status)
    {
        SQLiteDatabase dba = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("Rollno", roll);
        v.put("Status", status);


        long r = dba.insert("Attendence", null, v);

        if (r == -1) {
            return false;
        } else {
            return true;
        }
    }


}
