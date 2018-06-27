package com.utfpr.grupo2.projetov2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "controlefaltas.db";
    public static final String TABELA = "disciplina";
    public static final String ID = "_id";
    public static final String NOME_DISCIPLINA = "nome_disciplina";
    public static final String NUM_AULAS = "periodo";
    public static final String NUM_FALTAS = "num_faltas";
    public static final String PERCENT_FALTAS = "percent_faltas";
    private static final int VERSAO = 3;

    public CriaBanco(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "( "
                + ID + " integer primary key autoincrement,"
                + NOME_DISCIPLINA + " text,"
                + NUM_AULAS + " integer,"
                + NUM_FALTAS + " integer,"
                + PERCENT_FALTAS + " integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
