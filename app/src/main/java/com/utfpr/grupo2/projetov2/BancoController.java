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

    public String insereDados (String nomeDisciplina, int totalAulas, int faltas, int percent){
        ContentValues valores = new ContentValues();
        db = banco.getWritableDatabase();
        valores.put(CriaBanco.NOME_DISCIPLINA, nomeDisciplina);
        valores.put(CriaBanco.NUM_AULAS, totalAulas);
        valores.put(CriaBanco.NUM_FALTAS, faltas);
        valores.put(CriaBanco.PERCENT_FALTAS, percent);
        long resultado = db.insert("disciplina",null, valores);
        db.close();
        if(resultado > 0){
            return "Adicionado com sucesso";
        }
        return "Erro ao inserir no banco";
    }

    public Cursor carregaDadosById(int id){
        Cursor cursor;
        String [] campos = {CriaBanco.ID,CriaBanco.NOME_DISCIPLINA,CriaBanco.PERCENT_FALTAS, CriaBanco.NUM_AULAS, CriaBanco.NUM_FALTAS};
        db = banco.getReadableDatabase();
        String where = CriaBanco.ID + " = " + id;
        cursor = db.query(CriaBanco.TABELA,campos,where,null,null,null,null,null);
        if(cursor != null){
            cursor.moveToNext();
        }
        db.close();
        return cursor;
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

    public void alterarRegistro(int id, String nomeDisciplina, String percentFaltas){
        db = banco.getReadableDatabase();
        String where = CriaBanco.ID + " = " + id;
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.NOME_DISCIPLINA,nomeDisciplina);
        valores.put(CriaBanco.PERCENT_FALTAS,percentFaltas);
        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }
}
