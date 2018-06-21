package com.utfpr.grupo2.projetov2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    EditText nomeDisplina;
    EditText percentFaltas;
    Button alterar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Resumo");

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        nomeDisplina = (EditText) findViewById(R.id.edtAlterarNomeDisciplina);
        percentFaltas = (EditText) findViewById(R.id.edtAlterarPercent_Faltas);

        cursor = crud.carregaDadosById(Integer.parseInt(codigo));
        nomeDisplina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME_DISCIPLINA)));
        percentFaltas.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PERCENT_FALTAS)));
    }
}
