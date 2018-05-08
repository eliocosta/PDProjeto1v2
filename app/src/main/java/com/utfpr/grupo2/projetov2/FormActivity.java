package com.utfpr.grupo2.projetov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("Cadastro");
    }

    public void enviarForm(View v){

        EditText txtnomeDisciplina = (EditText)findViewById(R.id.nomeDisciplina);
        EditText txtaulasSemestre = (EditText)findViewById(R.id.aulasSemestre);
        EditText txtpercentFaltasPossiveis = (EditText)findViewById(R.id.percentFaltasPossiveis);
        EditText txtfaltasJaExistentes = (EditText)findViewById(R.id.faltasJaExistentes);

        Intent intent = new Intent(this, ResultActivity.class);
        Bundle params = new Bundle();

        params.putString("nome_disciplina", txtnomeDisciplina.getText().toString());
        params.putString("aulas_semestre", txtaulasSemestre.getText().toString());
        params.putString("percent_faltas", txtpercentFaltasPossiveis.getText().toString());
        params.putString("faltas_existentes", txtfaltasJaExistentes.getText().toString());


        intent.putExtras(params);
        startActivity(intent);
    }
}
