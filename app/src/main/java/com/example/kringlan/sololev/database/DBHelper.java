package com.example.kringlan.sololev.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.kringlan.sololev.model.User;


public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DB_HELPER";

    private static final String USER_TABLE = "users";
    private static final String USER_USERNAME = "username";
    private static final String USER_PASSWORD = "password";

    private static final int USER_USERNAME_COL = 1;
    private static final int USER_PASSWORD_COL = 2;

    public DBHelper(Context context) {
        super(context, "LevAppDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +
                USER_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                USER_USERNAME + " VARCHAR(25) NOT NULL," +
                USER_PASSWORD + " VARCHAR(25) NOT NULL" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cvs = new ContentValues();
        cvs.put(USER_USERNAME, username);
        cvs.put(USER_PASSWORD, password);

        long id = db.insert(USER_TABLE, null, cvs);
        Log.d(TAG, "Inserted new user: " + id);

        db.close();
    }

    public boolean findUser(String name) {
        SQLiteDatabase db = getReadableDatabase();


        Cursor c = db.query(USER_TABLE, null, USER_USERNAME, null, null, null, null);

        if(c.moveToFirst()) {
            do {
                if(c.getString(USER_USERNAME_COL).equals(name)) return true;
            } while (c.moveToNext());
        }

        db.close();
        return false;
    }

}