package com.utfpr.grupo2.projetov2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private CriaBanco banco;
    private SQLiteDatabase db;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }
}
