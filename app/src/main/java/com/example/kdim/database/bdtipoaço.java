package com.example.kdim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class bdtipoaço extends SQLiteOpenHelper {

    public bdtipoaço(Context context) {
        super(context, "bdaços", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(ScriptDDL.getCreateTabletipoaços());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(ScriptDDL.gravardadostipoaço());
    }
}
