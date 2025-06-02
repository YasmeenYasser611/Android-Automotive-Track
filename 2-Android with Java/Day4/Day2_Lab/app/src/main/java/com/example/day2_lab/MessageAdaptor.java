package com.example.day2_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MessageAdaptor
{
    private Context context ;
    private DataBaseHelper dbHelper;

    public MessageAdaptor (Context __context)
    {
        context = __context;
        dbHelper = new DataBaseHelper(__context);


    }

    public long insertMessage(Message message)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(DataBaseHelper.MOBILE_NUMBER, message.mobile);
        content.put(DataBaseHelper.MESSAGE , message.Message);

        long id = db.insert(DataBaseHelper.Table_Name , null , content) ;
        return id;

    }

    public Message findMessage(String phone)
    {
        Message msg = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String [] args = {phone};
        Cursor result = db.query(DataBaseHelper.Table_Name , null , "MOBILE_NUMBER = ? " , args , null , null , null);
        if(result != null)
        {
            result.moveToNext();
            msg = new Message(result.getString(0) , result.getString(1));

        }
        return msg;
    }


    static class DataBaseHelper  extends SQLiteOpenHelper
    {
        private static final int DataBase_Version = 1;
        private static final String DataBase_NAME = "mYDB.db";
        private static final String Table_Name = "Phone";
        private static final String MOBILE_NUMBER="MOBILE_NUMBER";
        private static final String MESSAGE="MESSAGE";
        private static final String CREATE_USER_MESSAGE_TABLE  = "CREATE TABLE " + Table_Name + " (" + MOBILE_NUMBER + " TEXT PRIMARY KEY, " + MESSAGE + " TEXT);";




        public DataBaseHelper(@Nullable Context context ) {
            super(context, DataBase_NAME, null, DataBase_Version);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_USER_MESSAGE_TABLE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {

        }
    }
}
