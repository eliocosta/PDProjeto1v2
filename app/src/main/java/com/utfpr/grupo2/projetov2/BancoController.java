package com.utfpr.grupo2.projetov2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private CriaBanco banco;
    private SQLiteDatabase db;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDados (String nomeDisciplina, String periodo, int percent){
        ContentValues valores = new ContentValues();
        db = banco.getWritableDatabase();
        valores.put(CriaBanco.NOME_DISCIPLINA, nomeDisciplina);
        valores.put(CriaBanco.PERIODO, periodo);
        valores.put(CriaBanco.PERCENT_FALTAS, percent);
        long resultado = db.insert("disciplina",null, valores);
        db.close();
        if(resultado > 0){
            return "Adicionado com sucesso";
        }
        return "Erro ao inserir no banco";
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String [] campos = {CriaBanco.ID,CriaBanco.NOME_DISCIPLINA};

        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,null,null,null,null,null,null);

        if(cursor != null){
            cursor.moveToNext();
        }
        db.close();
        return cursor;
    }
}
