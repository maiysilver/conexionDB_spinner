package com.example.conexiondb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class myDB {


    private static SQLiteDatabase database;
    private myDataBaseHelper dbHelper;

        public final static String EMP_TABLE="MyEmployees"; // name of table
        public final static String EMP_ID="_id"; // id value for employee
        public final static String EMP_NAME="name";  // name of employee


        public myDB(Context context){
            dbHelper = new myDataBaseHelper(context);
            database = dbHelper.getWritableDatabase();
        }


        public static long createRecords(String id, String name){
            ContentValues values = new ContentValues();
            values.put(EMP_ID, id);
            values.put(EMP_NAME, name);
            Log.e(id, name);
            return database.insert(EMP_TABLE, null, values);
        }

        public Cursor selectRecords() {
            String[] cols = new String[] {EMP_ID, EMP_NAME};
            Cursor mCursor = database.query(true, EMP_TABLE,cols,null
                    , null, null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor; // iterate to get each value.
        }

}

