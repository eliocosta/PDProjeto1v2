package com.utfpr.grupo2.projetov2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity  extends AppCompatActivity{

    EditText disciplina;
    EditText percent_faltas;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        disciplina = (EditText) findViewById(R.id.edtAlterarNomeDisciplina);
        percent_faltas = (EditText) findViewById(R.id.edtAlterarPercent_Faltas);
        alterar = (Button) findViewById(R.id.btnEditar);

        cursor = crud.carregaDadosById(Integer.parseInt(codigo));
        disciplina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME_DISCIPLINA)));
        percent_faltas.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PERCENT_FALTAS)));
    }

    public void alterar(View view){
        crud.alterarRegistro(Integer.parseInt(codigo), disciplina.getText().toString(), percent_faltas.getText().toString());
        finish();
    }
}
