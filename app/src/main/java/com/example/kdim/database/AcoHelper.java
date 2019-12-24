package com.example.kdim.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AcoHelper extends SQLiteOpenHelper {

    private final String SCRIPT_PARA_CRIAR_TABELA =
            "CREATE TABLE IF NOT EXISTS aco (" +
                "nome TEXT PRIMARY KEY," +
                "tensao_ruptura DOUBLE NOT NULL," +
                "tensao_escoamento DOUBLE NOT NULL" +
            ");";

    public AcoHelper(Context context) {
        super(context, "bd_aco", null, 1);
    }

    public SQLiteDatabase abrirConexao() {
        return this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_PARA_CRIAR_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // NADA POR ENQUANTO...
    }
}


