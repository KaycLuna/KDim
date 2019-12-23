package com.example.kdim.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kdim.modelo.Aco;

import java.util.ArrayList;
import java.util.List;

public class AcoDao {

    private SQLiteDatabase conexao;

    public AcoDao(AcoHelper acoHelper) {
        conexao = acoHelper.abrirConexao();
    }

    public void inserir(Aco aco) {
        conexao.execSQL("INSERT INTO aco (nome, tensao_ruptura, tensao_escoamento) VALUES(?, ?, ?);", new Object[]{
                aco.getNome(), aco.getTensaoDeRuptura(), aco.getTensaoDeEscoamento()
        });
    }

    public void deletar(String nome) {
        conexao.execSQL("DELETE FROM acco WHERE nome=?;", new Object[]{nome});
    }

    public Aco getAco(String nome) {
        Cursor cursor = conexao.rawQuery("SELECT* FROM aco WHERE nome=?;", new String[] {nome});
        Aco aco = new Aco();
        while(cursor.moveToNext()) {
            aco.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aco.setTensaoDeRuptura(cursor.getDouble(cursor.getColumnIndex("tensao_ruptura")));
            aco.setTensaoDeEscoamento(cursor.getDouble(cursor.getColumnIndex("tensao_escoamento")));
        }
        cursor.close();
        return aco;
    }

    public List<Aco> getTodosOsAcos() {
        Cursor cursor = conexao.rawQuery("SELECT* FROM aco;", null);
        List<Aco> lista = new ArrayList<>();
        while(cursor.moveToNext()) {
            Aco aco = new Aco();
            aco.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aco.setTensaoDeRuptura(cursor.getDouble(cursor.getColumnIndex("tensao_ruptura")));
            aco.setTensaoDeEscoamento(cursor.getDouble(cursor.getColumnIndex("tensao_escoamento")));
            lista.add(aco);
        }
        cursor.close();
        return lista;
    }

}
