package com.example.shixun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ShuJuKu extends SQLiteOpenHelper {
    public static final String CREATE_USER="create table User("
            +"Username text primary key,"
            +"Password text)";

    private Context mContext;

    public ShuJuKu(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER);
        Toast.makeText(mContext,"创建成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

